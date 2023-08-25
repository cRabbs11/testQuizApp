package com.ekochkov.testquizapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ekochkov.testquizapp.MainActivity
import com.ekochkov.testquizapp.R
import com.ekochkov.testquizapp.databinding.FragmentGameBinding
import com.ekochkov.testquizapp.di.data.entity.Question
import com.ekochkov.testquizapp.viewModel.GameFragmentViewModel
import com.squareup.picasso.Picasso

class GameFragment: Fragment() {

    val viewModel: GameFragmentViewModel by viewModels()
    lateinit var binding : FragmentGameBinding
    private var questionList = arrayListOf<Question>()
    private var questionNumber = 0
    lateinit var question: Question

    companion object {
        const val NEED_TO_SELECT_ANSWER = "необходимо выбрать ответ"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.questionsListLiveData.observe(viewLifecycleOwner) {
            this.questionList = it
            openNextQuestion()
        }

        binding.answersGroup.setOnCheckedChangeListener { radioGroup, checkedId ->
            when(checkedId) {
                binding.radioButton1.id -> {question.playerAnswer=binding.radioButton1.text.toString()}
                binding.radioButton2.id -> {question.playerAnswer=binding.radioButton2.text.toString()}
                binding.radioButton3.id -> {question.playerAnswer=binding.radioButton3.text.toString()}
                binding.radioButton4.id -> {question.playerAnswer=binding.radioButton4.text.toString()}
            }
        }

        binding.nextBtn.setOnClickListener {
            if (question.playerAnswer!=Question.NO_ANSWER) {
                questionNumber++
                openNextQuestion()
            } else {
                Toast.makeText(requireContext(), NEED_TO_SELECT_ANSWER, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun openNextQuestion() {
        if (questionNumber+1<=questionList.size) {
            question = questionList[questionNumber]
            Picasso.get().load(question.image).into(binding.imageVar)
            binding.radioButton1.text = question.answerVar1
            binding.radioButton2.text = question.answerVar2
            binding.radioButton3.text = question.answerVar3
            binding.radioButton4.text = question.answerVar4
            binding.questionText.text = question.question
            binding.answersGroup.clearCheck()
        } else {
            viewModel.saveAnswers(questionList)
            questionNumber = 0
            (activity as MainActivity).openResultsFragment()
        }
    }
}