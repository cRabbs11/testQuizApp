package com.ekochkov.testquizapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekochkov.testquizapp.databinding.ItemQuestionBinding
import com.ekochkov.testquizapp.di.data.entity.Question
import com.ekochkov.testquizapp.holders.QuestionHolder

class QuestionListAdapter: RecyclerView.Adapter<QuestionHolder>() {

    var questions = arrayListOf<Question>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        val binding = ItemQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        holder.bind(questions[position])
    }

    override fun getItemCount(): Int {
        return questions.size
    }

}