package com.ekochkov.testquizapp.di.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ekochkov.testquizapp.di.data.dao.QuizDao
import com.ekochkov.testquizapp.di.data.entity.Answer
import com.ekochkov.testquizapp.di.data.entity.Game
import com.ekochkov.testquizapp.di.data.entity.Question

@Database(entities = [
    Game::class,
    Question::class,
    Answer::class],
    version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun quizDao(): QuizDao

    companion object {
        const val DATABASE_NAME = "main_db"
        const val QUESTION_TABLE_NAME = "questions"
        const val ANSWER_TABLE_NAME = "answers"
        const val GAME_TABLE_NAME = "games"
    }
}