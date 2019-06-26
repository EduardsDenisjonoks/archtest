package com.exail.archtest.cats.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.exail.archtest.R
import com.exail.archtest.cats.models.Cat
import com.exail.archtest.core.adapters.DiffCallback
import com.exail.archtest.databinding.CatsItemImageViewBinding

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
class CatAdapter  : RecyclerView.Adapter<CatAdapter.CatViewHolder>(){

    private val cats = ArrayList<Cat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CatViewHolder(DataBindingUtil.inflate(inflater, R.layout.cats_item_image_view, parent, false))
    }

    override fun getItemCount() = cats.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        if (position == RecyclerView.NO_POSITION){
            return
        }
        holder.bind(cats[position])
    }

    fun setCats(newCats: List<Cat>?){
        if (newCats.isNullOrEmpty()){
            cats.clear()
            notifyDataSetChanged()
            return
        }
        val diffResult = DiffUtil.calculateDiff(DiffCallback(cats, newCats))
        cats.clear()
        cats.addAll(newCats)
        diffResult.dispatchUpdatesTo(this)
    }

    class CatViewHolder(private val binding: CatsItemImageViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cat: Cat) {
            binding.imageUrl = cat.imageUrl
        }
    }
}