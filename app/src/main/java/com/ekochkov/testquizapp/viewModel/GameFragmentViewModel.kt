package com.ekochkov.testquizapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekochkov.testquizapp.App
import com.ekochkov.testquizapp.di.data.entity.Question
import com.ekochkov.testquizapp.domian.Interactor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GameFragmentViewModel: ViewModel() {

    var questionsListLiveData = MutableLiveData<ArrayList<Question>>()

    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)

        viewModelScope.launch(Dispatchers.IO) {
            val list = interactor.getQuestions() as ArrayList
            questionsListLiveData.postValue(list)
        }

    }

    fun saveAnswers(list: List<Question>) {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.saveQuestions(list)
        }
    }
}