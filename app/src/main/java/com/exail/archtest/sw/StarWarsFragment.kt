package com.exail.archtest.sw


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.exail.archtest.R
import com.exail.archtest.core.base.BaseFragment
import com.exail.archtest.databinding.FragmentStarWarsBinding
import com.exail.archtest.sw.adapters.StarWarAdapter


/**
 * A simple [Fragment] subclass.
 *
 */
class StarWarsFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentStarWarsBinding>(
            inflater,
            R.layout.fragment_star_wars,
            container,
            false
        )

        intiListView(binding.starWarsList)
        analytics.eventOpenStarWardScreen()

        return binding.root
    }

    private fun intiListView(list: RecyclerView) {
        list.layoutManager = LinearLayoutManager(context)
        list.adapter = StarWarAdapter()
    }
}
