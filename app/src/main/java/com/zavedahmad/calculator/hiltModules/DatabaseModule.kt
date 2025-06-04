package com.zavedahmad.calculator.hiltModules

import android.content.Context
import androidx.room.Room
import com.zavedahmad.calculator.data.database.HistoryDAO
import com.zavedahmad.calculator.data.database.HistoryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun ProvideHistoryDatabase(@ApplicationContext Context: Context): HistoryDatabase
    {
        return Room.databaseBuilder(context = Context, HistoryDatabase::class.java, "history_database").build()
    }

    @Provides
    fun ProvideDao (historyDatabase: HistoryDatabase): HistoryDAO{
        return historyDatabase.historyDAO()
    }

}