package com.exail.archtest.cats


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.exail.archtest.R
import com.exail.archtest.cats.adapters.CatAdapter
import com.exail.archtest.cats.view.models.CatViewModel
import com.exail.archtest.core.Analytics
import com.exail.archtest.core.base.BaseFragment
import com.exail.archtest.databinding.FragmentCatsBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 *
 */
class CatsFragment : BaseFragment() {

    private val catViewModel: CatViewModel by viewModel()

    private lateinit var catAdapter: CatAdapter
    private lateinit var loaderView: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCatsBinding>(
            inflater,
            R.layout.fragment_cats,
            container,
            false
        )

        initCatListView(binding.catListView)
        initLoaderView(binding.srlCatList)
        initViewModel()
        analytics.eventOpenCatScreen()

        return binding.root
    }

    private fun initCatListView(listView: RecyclerView) {
        catAdapter = CatAdapter()
        listView.adapter = catAdapter
        listView.layoutManager = GridLayoutManager(context, 3)
    }

    private fun initLoaderView(loaderView: SwipeRefreshLayout) {
        this.loaderView = loaderView
        this.loaderView.setOnRefreshListener {
            catViewModel.loadCats()
        }
    }

    private fun initViewModel() {
        //data observer
        catViewModel.catsList.observe(
            viewLifecycleOwner,
            Observer { newCatList -> catAdapter.setCats(newCatList) })

        //loader observer
        catViewModel.showLoading.observe(
            viewLifecycleOwner,
            Observer { isLoading -> loaderView.isRefreshing = isLoading })

        //error observer
        catViewModel.showError.observe(
            viewLifecycleOwner,
            Observer { error -> Toast.makeText(context, error, Toast.LENGTH_LONG).show() })
    }
}
