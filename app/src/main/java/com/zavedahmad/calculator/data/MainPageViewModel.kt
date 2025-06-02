package com.zavedahmad.calculator.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.mariuszgromada.math.mxparser.Expression
import kotlin.math.sin

class MainPageViewModel : ViewModel() {
    private val _expression = MutableStateFlow("")
    val expression: StateFlow<String> = _expression.asStateFlow()

    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result.asStateFlow()

    fun resultService() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _result.value = Expression(_expression.value.toString()).calculate().toString()
            }

        }

    }

    fun updateString(addValue: String) {

        _expression.value = addValue
        resultService()
    }

    fun equal() {
        _expression.value = _result.value
    }

    fun backspace() {
        _expression.value = _expression.value.dropLast(1)
        resultService()
    }
}