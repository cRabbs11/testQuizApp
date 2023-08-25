package com.ekochkov.testquizapp.di.modules

import com.ekochkov.testquizapp.di.data.dao.QuizDao
import com.ekochkov.testquizapp.domian.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideInteractor(quizDao: QuizDao) = Interactor(quizDao)
}