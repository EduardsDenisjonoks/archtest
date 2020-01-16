package com.exail.archtest.bottom.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.exail.archtest.bottom.PageFragment
import kotlin.random.Random

class PageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 10

    override fun createFragment(position: Int): Fragment {
        return PageFragment.loadPage(position, generateContent())
    }

    private fun generateContent(): String {
        val randomStringBuilder = StringBuilder()
        val randomLength: Int = Random.nextInt(1000)
        var tempChar: Char
        for (i in 0 until randomLength) {
            tempChar = (Random.nextInt(96) + 32).toChar()
            randomStringBuilder.append(tempChar)
        }
        return randomStringBuilder.toString()
    }
}