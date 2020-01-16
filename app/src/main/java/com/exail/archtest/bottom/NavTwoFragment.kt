package com.exail.archtest.bottom


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.exail.archtest.R
import com.exail.archtest.bottom.adapters.PageRecyclerViewAdapter
import com.exail.archtest.core.base.BaseFragment
import com.exail.archtest.databinding.FragmentNavTwoBinding

/**
 * A simple [Fragment] subclass.
 */
class NavTwoFragment : BaseFragment() {

    private val pageAdapter: PageRecyclerViewAdapter by lazy { PageRecyclerViewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNavTwoBinding>(inflater, R.layout.fragment_nav_two, container, false)

        analytics.eventViewBottomNavFragment(2)
        binding.pager.adapter = pageAdapter
        binding.pager.setPageTransformer(ZoomOutPageTransformer())
        
        return binding.root
    }


}
