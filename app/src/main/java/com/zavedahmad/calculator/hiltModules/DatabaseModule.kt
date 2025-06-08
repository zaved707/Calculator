package com.zavedahmad.calculator.hiltModules

import android.content.Context
import androidx.room.Room
import com.zavedahmad.calculator.data.database.HistoryDAO
import com.zavedahmad.calculator.data.database.HistoryDatabase
import com.zavedahmad.calculator.data.database.PreferencesDao
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
    fun provideHistoryDatabase(@ApplicationContext context: Context): HistoryDatabase
    {
        return Room.databaseBuilder(context = context, HistoryDatabase::class.java, "history_database").build()
    }

    @Provides
    fun provideDao (historyDatabase: HistoryDatabase): HistoryDAO{
        return historyDatabase.historyDAO()
    }

    @Provides
    fun providePreferencesDao (historyDatabase: HistoryDatabase): PreferencesDao{
        return historyDatabase.preferencesDao()
    }

}