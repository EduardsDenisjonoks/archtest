package com.exail.archtest


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import com.exail.archtest.bottom.BottomNavActivity
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
        initBottomNavButton(binding.btnBottomNav)
        initVersionLabel(binding.versionLabel)

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

    private fun initBottomNavButton(button: MaterialButton){
        button.setOnClickListener { context?.startActivity(Intent(context, BottomNavActivity::class.java)) }
    }

    private fun initVersionLabel(textView: AppCompatTextView){
        textView.text = BuildConfig.VERSION_NAME
    }

}
