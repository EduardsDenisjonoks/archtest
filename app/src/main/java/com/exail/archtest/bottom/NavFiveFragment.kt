package com.exail.archtest.bottom


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.exail.archtest.R
import com.exail.archtest.core.base.BaseFragment
import com.exail.archtest.core.navigatePopUp
import com.exail.archtest.core.navigateTo
import com.exail.archtest.databinding.FragmentNavFiveBinding
import com.google.android.material.button.MaterialButton

/**
 * A simple [Fragment] subclass.
 */
class NavFiveFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNavFiveBinding>(inflater, R.layout.fragment_nav_five, container, false)

        setUpPopUpButton(binding.btnBackUp)
        setUpNavToThreeButton(binding.btnBackToThree)
        analytics.eventViewBottomNavFragment(5)

        return binding.root
    }

    private fun setUpPopUpButton(button: MaterialButton){
        button.setOnClickListener { it.navigatePopUp() }
    }

    private fun setUpNavToThreeButton(button: MaterialButton){
        button.setOnClickListener { it.navigateTo(R.id.action_navigation_five_to_navigation_three) }
    }
}
