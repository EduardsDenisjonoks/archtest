package com.exail.archtest.bottom


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.exail.archtest.R
import com.exail.archtest.core.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 */
class NavTwoFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_two, container, false)
    }


}
