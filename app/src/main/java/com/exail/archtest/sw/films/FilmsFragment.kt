package com.exail.archtest.sw.films


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.exail.archtest.R
import com.exail.archtest.core.base.BaseFragment
import com.exail.archtest.databinding.FragmentFilmsBinding
import com.exail.archtest.sw.adapters.FilmAdapter
import com.exail.archtest.sw.view.model.FilmsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class FilmsFragment : BaseFragment() {

    private val filmsViewModel: FilmsViewModel by viewModel()
    private lateinit var loaderView: SwipeRefreshLayout
    private val filmAdapter: FilmAdapter by lazy { FilmAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFilmsBinding>(
            inflater,
            R.layout.fragment_films,
            container,
            false
        )

        initDataBinding(binding)
        initFilmListView(binding.filmListView)
        initLoaderView(binding.swipeToRefresh)
        initViewModel()

        return binding.root
    }

    private fun initDataBinding(binding: FragmentFilmsBinding) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.filmsVm = filmsViewModel
    }

    private fun initFilmListView(list: RecyclerView) {
        list.layoutManager = LinearLayoutManager(context)
        list.adapter = filmAdapter
    }

    private fun initLoaderView(loaderView: SwipeRefreshLayout) {
        this.loaderView = loaderView
        this.loaderView.setOnRefreshListener {
            filmsViewModel.refreshData()
        }
    }

    private fun initViewModel() {
        filmsViewModel.filmList.observe(viewLifecycleOwner, Observer { filmList ->
            filmAdapter.submitList(filmList)
        })

        filmsViewModel.showLoading.observe(
            viewLifecycleOwner,
            Observer { isLoading -> loaderView.isRefreshing = isLoading })


        filmsViewModel.search.observe(viewLifecycleOwner, Observer { searchQuery ->
            run {
                if (searchQuery.isNullOrBlank() || searchQuery.length >= 2) {
                    filmsViewModel.setSearchQuery(searchQuery)
                }
            }
        })
    }

}
