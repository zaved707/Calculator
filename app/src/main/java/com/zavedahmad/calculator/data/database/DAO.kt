package com.zavedahmad.calculator.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDAO {
    @Insert
    suspend fun addHistory(historyEntry : HistoryEntity)

    @Query("SELECT * FROM HistoryTable ORDER BY `key` DESC")
    fun getAllHistory(): Flow<List<HistoryEntity>>

    @Query("DELETE FROM HistoryTable WHERE `key` = :historyId")
    suspend fun deleteHistoryByKey(historyId: Long)
}