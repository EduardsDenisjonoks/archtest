package com.exail.archtest.sw.people


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
 *
 */
class PersonFragment : Fragment() {

    private val args : PersonFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Toast.makeText(context, args.person?.name ?: "no name", Toast.LENGTH_LONG).show()

        return inflater.inflate(R.layout.fragment_person, container, false)
    }


}
