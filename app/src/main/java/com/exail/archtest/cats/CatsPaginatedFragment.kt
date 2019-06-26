package com.exail.archtest.cats


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.exail.archtest.R
import com.exail.archtest.cats.adapters.CatPaginatedAdapter
import com.exail.archtest.cats.view.models.CatPaginatedViewModel
import com.exail.archtest.databinding.FragmentCatsPaginatedBinding
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 *
 */
class CatsPaginatedFragment : Fragment() {


    private val catPaginatedViewModel: CatPaginatedViewModel by viewModel()
    private lateinit var catPaginatedAdapter: CatPaginatedAdapter
    private lateinit var loaderView: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCatsPaginatedBinding>(
            inflater,
            R.layout.fragment_cats_paginated,
            container,
            false
        )

        initCatListView(binding.catListView)
        initLoaderView(binding.srlCatList)
        initViewModel()

        return binding.root
    }


    private fun initCatListView(listView: RecyclerView) {
        catPaginatedAdapter = CatPaginatedAdapter()
        listView.adapter = catPaginatedAdapter
        listView.layoutManager = GridLayoutManager(context, 3)
    }

    private fun initLoaderView(loaderView: SwipeRefreshLayout) {
        this.loaderView = loaderView
        this.loaderView.setOnRefreshListener {
            catPaginatedViewModel.refreshData()
        }
    }

    private fun initViewModel() {
        //data observer
        catPaginatedViewModel.catList.observe(
            viewLifecycleOwner,
            Observer { newCatList -> catPaginatedAdapter.submitList(newCatList) })

        //loader observer
        catPaginatedViewModel.showLoading.observe(
             viewLifecycleOwner,
             Observer { isLoading -> loaderView.isRefreshing = isLoading })

        //error observer
        catPaginatedViewModel.showError.observe(
             viewLifecycleOwner,
             Observer { error -> Toast.makeText(context, error, Toast.LENGTH_LONG).show() })
    }

}
