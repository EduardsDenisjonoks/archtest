package com.exail.archtest.sw.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.exail.archtest.R
import com.exail.archtest.core.adapters.DiffItemCallback
import com.exail.archtest.core.navigateTo
import com.exail.archtest.databinding.SwItemStringBinding
import com.exail.archtest.sw.films.FilmsFragmentDirections
import com.exail.archtest.sw.models.Film

class FilmsAdapter : PagedListAdapter<Film, FilmsAdapter.SwItem>(DiffItemCallback<Film>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwItem {
        return SwItem(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.sw_item_string,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SwItem, position: Int) {
        holder.bindView(super.getItem(position))
    }

    inner class SwItem(private val binding: SwItemStringBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { view ->
                view.navigateTo(
                    FilmsFragmentDirections.actionFilmsFragmentToFilmFragment(
                        getItem(
                            adapterPosition
                        )
                    )
                )
            }
        }

        fun bindView(film: Film?) {
            binding.label = film?.title
        }
    }
}