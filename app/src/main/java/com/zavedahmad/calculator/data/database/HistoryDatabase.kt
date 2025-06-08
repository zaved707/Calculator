package com.zavedahmad.calculator.data.database


import androidx.room.Database

import androidx.room.RoomDatabase


@Database(entities = [HistoryEntity::class, PreferencesEntity::class], version = 1)
abstract class HistoryDatabase : RoomDatabase(){
    abstract fun historyDAO(): HistoryDAO
    abstract fun preferencesDao(): PreferencesDao
}