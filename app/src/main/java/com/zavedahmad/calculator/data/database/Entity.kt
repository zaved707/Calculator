package com.zavedahmad.calculator.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HistoryTable")
data class HistoryEntity (
    @PrimaryKey(autoGenerate = false)
    val key: Long,
    val expression: String,
    val answer : String

)