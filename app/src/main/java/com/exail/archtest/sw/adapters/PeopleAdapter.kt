package com.exail.archtest.sw.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.exail.archtest.R
import com.exail.archtest.core.adapters.DiffItemCallback
import com.exail.archtest.core.navigateTo
import com.exail.archtest.databinding.SwItemPersonBinding
import com.exail.archtest.sw.models.People

/**
 * Created by eduardsdenisjonoks  on 2019-06-06.
 */
class PeopleAdapter : PagedListAdapter<People, PeopleAdapter.SwItem>(DiffItemCallback<People>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwItem {
        return SwItem(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.sw_item_person,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SwItem, position: Int) {
        holder.bindView(super.getItem(position))
    }


    class SwItem(private val binding: SwItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { view ->
                view.navigateTo(R.id.action_peoplesFragment_to_personFragment)
            }
        }

        fun bindView(person: People?) {
            binding.label = person?.name
        }
    }
}