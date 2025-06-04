package com.zavedahmad.calculator.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDAO {
    @Insert
    suspend fun addHistory(historyEntry : HistoryEntity)

    @Query("SELECT * FROM  HistoryTable")
    fun getAllHistory(): Flow<List<HistoryEntity>>
}