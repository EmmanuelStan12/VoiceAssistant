package com.codedev.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codedev.home.adapters.RVFeatureAdapter
import com.codedev.home.databinding.FragmentHomeBinding
import com.codedev.ui_base_lib.DICTIONARY_ACTIVITY_INTENT_FILTER

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.bind(view)

        binding.rvFeatureItems.layoutManager = LinearLayoutManager(requireContext())
        val adapter = RVFeatureAdapter { route ->
            when (route) {
                1 -> Intent(DICTIONARY_ACTIVITY_INTENT_FILTER).apply {
                    setPackage(requireContext().packageName)
                }.also { requireContext().startActivity(it) }
            }
        }
        binding.rvFeatureItems.adapter = adapter
        binding.rvFeatureItems.setHasFixedSize(true)

    }
}