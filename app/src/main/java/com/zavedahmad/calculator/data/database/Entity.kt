package com.zavedahmad.calculator.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HistoryTable")
data class HistoryEntity (
    @PrimaryKey(autoGenerate = true)
    val key:Int= 0,
    val expression: String,
    val answer : String

)