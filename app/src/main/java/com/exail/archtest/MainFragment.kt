package com.exail.archtest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.exail.archtest.core.navigateTo
import com.exail.archtest.databinding.FragmentMainBinding
import com.google.android.material.button.MaterialButton

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )

        initCatButton(binding.btnCats)
        initCatPaginatedButton(binding.btnCatsPaginated)
        initChuckNorrisButton(binding.btnChuckNorris)
        initTestGroundButton(binding.btnTestGround)
        initStarWarsButton(binding.btnStarWars)

        return binding.root
    }

    private fun initCatButton(button: MaterialButton) {
        button.setOnClickListener { it.navigateTo(R.id.catsFragment) }
    }

    private fun initCatPaginatedButton(button: MaterialButton) {
        button.setOnClickListener { it.navigateTo(R.id.catsPaginatedFragment) }
    }

    private fun initChuckNorrisButton(button: MaterialButton) {
        button.setOnClickListener { it.navigateTo(R.id.chuckNorrisFragment) }
    }

    private fun initTestGroundButton(button: MaterialButton) {
        button.setOnClickListener { it.navigateTo(R.id.testGroundFragment) }
    }

    private fun initStarWarsButton(button: MaterialButton){
        button.setOnClickListener { it.navigateTo(R.id.starWarsFragment) }
    }

}
