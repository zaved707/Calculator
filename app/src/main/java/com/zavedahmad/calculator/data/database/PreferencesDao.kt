package com.zavedahmad.calculator.data.database

import androidx.room.Dao
import androidx.room.Query

import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PreferencesDao {
    @Upsert
    suspend fun updatePreference(preferencesEntity: PreferencesEntity)

    @Query("SELECT * FROM PreferencesTable WHERE `key` = :key")
    fun getPreferenceByKeySync(key: String): PreferencesEntity?

    @Query("SELECT * FROM PreferencesTable")
    fun getPreferencesAll(): Flow<List<PreferencesEntity>>

    @Query("SELECT * FROM PreferencesTable WHERE `key` = :key")
    fun getPreferenceByKey(key: String) : Flow<PreferencesEntity?>
}