package com.exail.archtest.sw.films


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.exail.archtest.R
import com.exail.archtest.databinding.FragmentFilmBinding
import com.exail.archtest.sw.adapters.FilmAdapter
import com.exail.archtest.sw.view.model.FilmViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * A simple [Fragment] subclass.
 */
class FilmFragment : Fragment() {

    private val args: FilmFragmentArgs by navArgs()
    private val filmViewModel: FilmViewModel by viewModel { parametersOf(args.film) }
    private val filmAdapter: FilmAdapter by lazy { FilmAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFilmBinding>(
            inflater,
            R.layout.fragment_film,
            container,
            false
        )

        initDataBinding(binding)
        initFilmDetails(binding.filmDetails)

        return binding.root
    }

    private fun initDataBinding(binding: FragmentFilmBinding) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.filmVm = filmViewModel
    }

    private fun initFilmDetails(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = filmAdapter
        filmAdapter.setFilm(filmViewModel.film)
    }


}
