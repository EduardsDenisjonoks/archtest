package com.exail.archtest.chuck.norris


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.exail.archtest.R
import com.exail.archtest.chuck.norris.view.model.ChuckNorrisViewModel
import com.exail.archtest.core.base.BaseFragment
import com.exail.archtest.databinding.FragmentChuckNorrisBinding
import com.google.android.material.button.MaterialButton
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 *
 */
class ChuckNorrisFragment :  BaseFragment() {

    private val chuckNorrisViewModel: ChuckNorrisViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentChuckNorrisBinding>(
            inflater,
            R.layout.fragment_chuck_norris,
            container,
            false
        )

        setViewModelToBinding(binding)
        initViewModel()
        initNextJokeButton(binding.btnNextJoke)
        analytics.eventOpenChuckNorrisScreen()

        return binding.root
    }

    private fun setViewModelToBinding(binding: FragmentChuckNorrisBinding) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.chuckNorrisVm = chuckNorrisViewModel
    }

    private fun initViewModel() {
        //error observer
        chuckNorrisViewModel.showError.observe(
            viewLifecycleOwner,
            Observer { error -> Toast.makeText(context, error, Toast.LENGTH_LONG).show() })
    }

    private fun initNextJokeButton(button: MaterialButton) {
        button.setOnClickListener { chuckNorrisViewModel.randomJoke() }
    }

}
