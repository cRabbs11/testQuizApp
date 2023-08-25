package com.ekochkov.testquizapp.domian

import com.ekochkov.testquizapp.di.data.dao.QuizDao
import com.ekochkov.testquizapp.di.data.entity.Question
import com.ekochkov.testquizapp.utils.PopulateDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Interactor(private val quizDao: QuizDao) {

    suspend fun getQuestions() = quizDao.getQuestions()

    fun populateDB() {
        MainScope().launch(Dispatchers.IO) {
            if (getQuestions().isEmpty()) {
                val populateDB = PopulateDB()
                saveQuestions(populateDB.getQuestions())
            }
        }
    }

    suspend fun saveQuestions(list: List<Question>) {
        quizDao.saveQuestions(list)
    }


    fun dropAnswers() {
        MainScope().launch(Dispatchers.IO) {
            val list = getQuestions()
            list.forEach {
                it.playerAnswer = Question.NO_ANSWER
            }
            saveQuestions(list)
        }
    }

}