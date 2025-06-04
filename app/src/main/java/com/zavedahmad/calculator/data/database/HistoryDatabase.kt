package com.zavedahmad.calculator.data.database


import androidx.room.Database

import androidx.room.RoomDatabase


@Database(entities = [HistoryEntity::class], version = 1)
abstract class HistoryDatabase : RoomDatabase(){
    abstract fun historyDAO(): HistoryDAO
}