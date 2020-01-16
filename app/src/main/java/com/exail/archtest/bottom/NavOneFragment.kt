package com.exail.archtest.bottom


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.exail.archtest.R
import com.exail.archtest.bottom.adapters.PageAdapter
import com.exail.archtest.core.base.BaseFragment
import com.exail.archtest.databinding.FragmentNavOneBinding

/**
 * A simple [Fragment] subclass.
 */
class NavOneFragment : BaseFragment() {

    private val pageAdapter: PageAdapter by lazy { PageAdapter(requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNavOneBinding>(inflater, R.layout.fragment_nav_one, container, false)

        analytics.eventViewBottomNavFragment(1)

        binding.pager.adapter = pageAdapter

        return binding.root
    }


}
