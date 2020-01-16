package com.exail.archtest.bottom


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.exail.archtest.R
import com.exail.archtest.databinding.FragmentPageBinding

/**
 * A simple [Fragment] subclass.
 */
class PageFragment : Fragment() {

    companion object {
        private const val PAGE: String = "page"
        private const val CONTENT: String = "content"

        fun loadPage(page: Int, content: String?): PageFragment {
            return PageFragment().apply {
                val bundle = Bundle()
                bundle.putInt(PAGE, page)
                bundle.putString(CONTENT, content)
                this.arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPageBinding>(
            inflater,
            R.layout.fragment_page,
            container,
            false
        )

        initDataBinding(binding)

        return binding.root
    }

    private fun initDataBinding(binding: FragmentPageBinding) {
        arguments?.let {
            binding.page = it.getInt(PAGE, 0).toString()
            binding.content = it.getString(CONTENT)
        }
    }
}
