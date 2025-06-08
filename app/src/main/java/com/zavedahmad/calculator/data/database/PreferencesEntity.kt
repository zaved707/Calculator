package com.zavedahmad.calculator.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PreferencesTable")
data class PreferencesEntity (
    @PrimaryKey
    val key: String,
    val value: String
)