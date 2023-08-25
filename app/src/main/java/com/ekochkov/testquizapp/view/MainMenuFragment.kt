package com.ekochkov.testquizapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ekochkov.testquizapp.MainActivity
import com.ekochkov.testquizapp.databinding.FragmentMainMenuBinding
import com.ekochkov.testquizapp.viewModel.MainMenuFragmentViewModel

class MainMenuFragment: Fragment() {

    val viewModel: MainMenuFragmentViewModel by viewModels()
    lateinit var binding : FragmentMainMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startBtn.setOnClickListener {
            viewModel.dropAnswers()
            (activity as MainActivity).openGameFragment()
        }
    }
}