package com.ekochkov.testquizapp.di

import com.ekochkov.testquizapp.MainActivity
import com.ekochkov.testquizapp.di.modules.DataModule
import com.ekochkov.testquizapp.di.modules.DomainModule
import com.ekochkov.testquizapp.viewModel.GameFragmentViewModel
import com.ekochkov.testquizapp.viewModel.MainMenuFragmentViewModel
import com.ekochkov.testquizapp.viewModel.ResultsFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DataModule::class,
    DomainModule::class
])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainMenuFragmentViewModel: MainMenuFragmentViewModel)
    fun inject(gameFragmentViewModel: GameFragmentViewModel)
    fun inject(resultsFragmentViewModel: ResultsFragmentViewModel)
}