package com.exail.archtest.cats.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.exail.archtest.R
import com.exail.archtest.cats.models.Cat
import com.exail.archtest.core.adapters.DiffItemCallback
import com.exail.archtest.databinding.CatsItemImageViewBinding

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
class CatPaginatedAdapter : PagedListAdapter<Cat, CatPaginatedAdapter.CatViewHolder>(DiffItemCallback<Cat>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CatViewHolder(
            DataBindingUtil.inflate(
                inflater,
                R.layout.cats_item_image_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CatViewHolder(private val binding: CatsItemImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cat: Cat?) {
            binding.imageUrl = cat?.imageUrl
        }
    }
}