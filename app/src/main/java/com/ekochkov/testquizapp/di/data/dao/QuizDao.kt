package com.ekochkov.testquizapp.di.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ekochkov.testquizapp.di.data.AppDatabase
import com.ekochkov.testquizapp.di.data.entity.Question

@Dao
interface QuizDao {

    @Query("SELECT * FROM ${AppDatabase.QUESTION_TABLE_NAME}")
    suspend fun getQuestions(): List<Question>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveQuestions(list: List<Question>): List<Long>
}