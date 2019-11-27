package com.exail.archtest.sw.people


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.exail.archtest.R
import com.exail.archtest.core.base.BaseFragment
import com.exail.archtest.databinding.FragmentPeopleBinding
import com.exail.archtest.sw.adapters.PeopleAdapter
import com.exail.archtest.sw.view.model.PeopleViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 *
 */
class PeopleFragment : BaseFragment() {

    private val peopleViewModel: PeopleViewModel by viewModel()
    private lateinit var loaderView: SwipeRefreshLayout
    private val peopleAdapter: PeopleAdapter by lazy { PeopleAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPeopleBinding>(
            inflater,
            R.layout.fragment_people,
            container,
            false
        )

        initDataBinding(binding)
        initPeopleListView(binding.peopleListView)
        initLoaderView(binding.swipeToRefresh)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initLiveDataObservers()
    }

    private fun initDataBinding(binding: FragmentPeopleBinding){
        binding.lifecycleOwner = viewLifecycleOwner
        binding.peopleVm = peopleViewModel
    }

    private fun initPeopleListView(list: RecyclerView) {
        list.layoutManager = LinearLayoutManager(context)
        list.adapter = peopleAdapter
    }

    private fun initLoaderView(loaderView: SwipeRefreshLayout) {
        this.loaderView = loaderView
        this.loaderView.setOnRefreshListener {
            peopleViewModel.refreshData()
        }
    }

    private fun initLiveDataObservers() {
        peopleViewModel.peopleList.observe(viewLifecycleOwner, Observer { peopleList ->
            peopleAdapter.submitList(peopleList)
        })

        peopleViewModel.showLoading.observe(
            viewLifecycleOwner,
            Observer { isLoading -> loaderView.isRefreshing = isLoading })


        peopleViewModel.search.observe(viewLifecycleOwner, Observer { searchQuery ->
            run {
                if (searchQuery.isNullOrBlank() || searchQuery.length >= 2) {
                    peopleViewModel.setSearchQuery(searchQuery)
                }
            }
        })
    }
}
