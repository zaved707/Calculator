package com.zavedahmad.calculator.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zavedahmad.calculator.data.database.HistoryDAO
import com.zavedahmad.calculator.data.database.HistoryEntity
import com.zavedahmad.calculator.data.database.PreferencesDao
import com.zavedahmad.calculator.data.database.PreferencesEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.mariuszgromada.math.mxparser.Expression
import java.time.Instant
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(
    val dao: HistoryDAO,
    val preferencesDao: PreferencesDao
) : ViewModel() {
    private val _expression = MutableStateFlow("")
    val expression: StateFlow<String> = _expression.asStateFlow()

    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result.asStateFlow()

    private val _historyList = MutableStateFlow<List<HistoryEntity>>(emptyList())
    val historyList: StateFlow<List<HistoryEntity>> = _historyList.asStateFlow()

    private val _theme = MutableStateFlow("")
    val theme: StateFlow<String> = _theme.asStateFlow()


    init {


        viewModelScope.launch(Dispatchers.IO) {

            preferencesDao.getPreferenceByKey("theme")
                .collect { preference ->
                    if (preference == null) {
                        preferencesDao.updatePreference(PreferencesEntity("theme", "System"))
                    }
                    else {
                        _theme.value = preference.value
                    }
                }

        }
        // Collect the Flow from the DAO in a lifecycle-aware manner
        viewModelScope.launch(Dispatchers.IO) {
            dao.getAllHistory().collect { history ->
                _historyList.value = history
            }
        }
    }

    //    val db = HistoryDatabase.getDatabase(context)
    fun resultService() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _result.value = Expression(_expression.value.toString()).calculate().toString()
            }

        }

    }

    fun deleteItemByKey(key: Long) {
        viewModelScope.launch { dao.deleteHistoryByKey(key) }
    }

    fun updateString(addValue: String) {

        _expression.value = addValue
        resultService()
    }

    fun equal() {
        val backupExpression = _expression.value

        _expression.value = _result.value
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                dao.addHistory(
                    HistoryEntity(
                        key = Instant.now().toEpochMilli(),
                        expression = backupExpression,
                        answer = _result.value
                    )
                )
            }
        }


    }

    fun getThemePreference() {
        viewModelScope.launch { withContext(Dispatchers.IO) { } }


    }

    fun setThemePreferences(value: String) {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                preferencesDao.updatePreference(
                    PreferencesEntity("theme", value)
                )
            }
        }
    }

    fun backspace() {
        _expression.value = _expression.value.dropLast(1)
        resultService()
    }
}