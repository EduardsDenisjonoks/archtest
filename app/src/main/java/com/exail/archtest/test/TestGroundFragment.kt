package com.exail.archtest.test


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.exail.archtest.R
import com.exail.archtest.databinding.FragmentTestGroundBinding
import com.exail.archtest.test.view.model.TestGroundViewModel
import com.google.android.material.button.MaterialButton
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 *
 */
class TestGroundFragment : Fragment() {

    private val testGroundViewModel: TestGroundViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTestGroundBinding>(
            inflater,
            R.layout.fragment_test_ground,
            container,
            false
        )

        setViewModelToBinding(binding)
        initPlusButton(binding.btnPlus)
        initMinusButton(binding.btnMinus)
        initObserver()

        return binding.root
    }

    private fun setViewModelToBinding(binding: FragmentTestGroundBinding) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.testGroundVm = testGroundViewModel
    }

    private fun initPlusButton(button: MaterialButton) {
        button.setOnClickListener { testGroundViewModel.plus() }
    }

    private fun initMinusButton(button: MaterialButton) {
        button.setOnClickListener { testGroundViewModel.minus() }
    }

    private fun initObserver() {
        testGroundViewModel.selectedItem.observe(
            viewLifecycleOwner,
            Observer { index -> testGroundViewModel.updateUserText(index) })
    }

}
