package com.exail.archtest.bottom.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.exail.archtest.R
import com.exail.archtest.databinding.BottomPageViewBinding

class PageRecyclerViewAdapter : RecyclerView.Adapter<PageRecyclerViewAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.bottom_page_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView()
    }

    class ImageViewHolder(private val binding: BottomPageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView() {
            binding.image = "https://picsum.photos/30${adapterPosition}"
        }
    }
}