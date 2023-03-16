package com.codedev.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.codedev.home.adapters.VPOnBoardingAdapter
import com.codedev.home.databinding.FragmentOnBoardingBinding

class OnBoardingFragment: Fragment(R.layout.fragment_on_boarding) {

    private lateinit var binding: FragmentOnBoardingBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentOnBoardingBinding.bind(view)


        val adapter = VPOnBoardingAdapter {}
        binding.apply {
            vpOnBoarding.adapter = adapter
            dotsIndicator.attachTo(vpOnBoarding)

            vpOnBoarding.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    if (position == adapter.itemCount - 1) {
                        btnForward.isEnabled = false
                        btnBack.isEnabled = true
                        btnSkip.text = "Let's Begin"
                    } else if(position == 0) {
                        btnBack.isEnabled = false
                        btnForward.isEnabled = true
                    } else {
                        btnBack.isEnabled = true
                        btnForward.isEnabled = true
                    }
                }
            })

            btnSkip.setOnClickListener {
                findNavController().navigate(R.id.action_onBoardingFragment_to_homeFragment)
            }

            btnForward.setOnClickListener {
                if (vpOnBoarding.currentItem != adapter.itemCount - 1)
                    vpOnBoarding.setCurrentItem(vpOnBoarding.currentItem + 1, true)
                else
                    findNavController().navigate(R.id.action_onBoardingFragment_to_homeFragment)
            }

            btnBack.setOnClickListener {
                if (vpOnBoarding.currentItem != 0)
                    vpOnBoarding.setCurrentItem(vpOnBoarding.currentItem - 1, true)
            }

        }

    }

    private fun handleViewOnClick() {
        binding.apply {
        }
    }

    private fun viewToggle(selectedIndex: Int) {

    }

}

