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
import com.exail.archtest.databinding.FragmentNavThreeBinding
import com.google.android.material.button.MaterialButton

/**
 * A simple [Fragment] subclass.
 */
class NavThreeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNavThreeBinding>(inflater, R.layout.fragment_nav_three, container, false)

        initNavToFourButton(binding.btnNavToFour)

        return binding.root
    }

    private fun initNavToFourButton(button: MaterialButton){
        button.setOnClickListener { it.navigateTo(R.id.action_navigation_three_to_navigation_four) }
    }

}
