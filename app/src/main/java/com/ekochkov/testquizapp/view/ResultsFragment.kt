package com.ekochkov.testquizapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ekochkov.testquizapp.adapters.QuestionListAdapter
import com.ekochkov.testquizapp.databinding.FragmentResultsBinding
import com.ekochkov.testquizapp.viewModel.ResultsFragmentViewModel

class ResultsFragment: Fragment() {

    val viewModel: ResultsFragmentViewModel by viewModels()
    lateinit var binding : FragmentResultsBinding

    lateinit var adapter: QuestionListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = QuestionListAdapter()

        binding.recyclerView.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(binding.recyclerView.context, LinearLayoutManager.VERTICAL)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)

        viewModel.questionsListLiveData.observe(viewLifecycleOwner) {
            adapter.questions = it
            adapter.notifyDataSetChanged()

            val questionsCount = it.size
            var rightAnswers = 0
            it.forEach {
                if (it.playerAnswer==it.rightAnswer) {
                    rightAnswers++
                }
            }
            val resultText = "Результаты: $rightAnswers/$questionsCount"
            binding.resultText.text = resultText
        }
    }
}