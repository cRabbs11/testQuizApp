package com.ekochkov.testquizapp.viewModel

import androidx.lifecycle.ViewModel
import com.ekochkov.testquizapp.App
import com.ekochkov.testquizapp.domian.Interactor
import javax.inject.Inject

class MainMenuFragmentViewModel: ViewModel() {

    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
    }

    fun dropAnswers() {
        interactor.dropAnswers()
    }
}