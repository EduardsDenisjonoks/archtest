package com.exail.archtest.sw.people


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exail.archtest.R
import com.exail.archtest.databinding.FragmentPersonBinding
import com.exail.archtest.sw.adapters.PersonAdapter
import com.exail.archtest.sw.view.model.PersonViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


/**
 * A simple [Fragment] subclass.
 *
 */
class PersonFragment : Fragment() {

    private val args: PersonFragmentArgs by navArgs()
    private val personViewModel by viewModel<PersonViewModel> { parametersOf(args.person) }
    private val personAdapter by lazy { PersonAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPersonBinding>(inflater, R.layout.fragment_person, container, false)

        initDataBinding(binding)
        initFilmDetails(binding.otherDetails)

        return binding.root
    }

    private fun initDataBinding(binding: FragmentPersonBinding) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.personVm = personViewModel
    }

    private fun initFilmDetails(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = personAdapter
        personAdapter.setPerson(personViewModel.getPerson())
    }

}
