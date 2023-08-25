package com.ekochkov.testquizapp.holders

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ekochkov.testquizapp.R
import com.ekochkov.testquizapp.databinding.ItemQuestionBinding
import com.ekochkov.testquizapp.di.data.entity.Question

class QuestionHolder(private val binding: ItemQuestionBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(question: Question) {
        binding.question.text = question.question
        binding.answer.text = question.playerAnswer
        if (question.playerAnswer==question.rightAnswer) {
            binding.answer.background = ContextCompat.getDrawable(binding.root.context, R.color.green)
        } else {
            binding.answer.background = ContextCompat.getDrawable(binding.root.context, R.color.red)
        }
    }
}