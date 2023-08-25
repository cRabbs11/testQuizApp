package com.ekochkov.testquizapp.di.modules

import android.content.Context
import androidx.room.Room
import com.ekochkov.testquizapp.di.data.AppDatabase
import com.ekochkov.testquizapp.di.data.dao.QuizDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule(val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Singleton
    @Provides
    fun provideDao(context: Context): QuizDao {
        val database = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build().quizDao()
        return database
    }
}