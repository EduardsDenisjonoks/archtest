package com.exail.archtest.bottom


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.exail.archtest.R
import com.exail.archtest.core.base.BaseFragment
import com.exail.archtest.core.navigateTo
import com.exail.archtest.databinding.FragmentNavFourBinding
import com.google.android.material.button.MaterialButton

/**
 * A simple [Fragment] subclass.
 */
class NavFourFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNavFourBinding>(inflater, R.layout.fragment_nav_four, container, false)

        initNavToFiveButton(binding.btnNavToFive)
        analytics.eventViewBottomNavFragment(4)

        return binding.root
    }
    
    private fun initNavToFiveButton(button: MaterialButton){
        button.setOnClickListener { it.navigateTo(R.id.action_navigation_four_to_navigation_five) }
    }


}
