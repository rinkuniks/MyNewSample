package com.nikhil.mynewsample.screen.dashboard.ui.test

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nikhil.mynewsample.R
import com.nikhil.mynewsample.databinding.FragmentStatisticBinding
import com.nikhil.mynewsample.databinding.FragmentTestBinding
import com.nikhil.mynewsample.screen.dashboard.ui.statistic.StatisticViewModel

class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val testViewModel =
            ViewModelProvider(this)[TestViewModel::class.java]

        _binding = FragmentTestBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTest
        testViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}