package com.exail.archtest.sw.films


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs

import com.exail.archtest.R

/**
 * A simple [Fragment] subclass.
 */
class FilmFragment : Fragment() {

    private val args : FilmFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Toast.makeText(context, args.film?.title ?: "no title", Toast.LENGTH_LONG).show()

        return inflater.inflate(R.layout.fragment_film, container, false)
    }


}
