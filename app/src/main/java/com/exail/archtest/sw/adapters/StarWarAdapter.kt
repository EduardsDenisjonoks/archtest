package com.exail.archtest.sw.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.exail.archtest.R
import com.exail.archtest.core.navigateTo
import com.exail.archtest.databinding.SwItemLabelBinding

/**
 * Created by eduardsdenisjonoks  on 2019-06-06.
 */
class StarWarAdapter : RecyclerView.Adapter<StarWarAdapter.SwItem>() {

    private val options = listOf(
        R.string.sw_films,
        R.string.sw_people,
        R.string.sw_planets,
        R.string.sw_species,
        R.string.sw_star_ships,
        R.string.sw_vehicles
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwItem {
        return SwItem(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.sw_item_label,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = options.size

    override fun onBindViewHolder(holder: SwItem, position: Int) {
        holder.bindView(options[position])
    }

    class SwItem(val binding: SwItemLabelBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { view ->
                when (adapterPosition) {
                    0 -> view.navigateTo(R.id.action_starWarsFragment_to_filmsFragment)
                    1 -> view.navigateTo(R.id.action_starWarsFragment_to_peoplesFragment)
                }

            }
        }

        fun bindView(@StringRes label: Int) {
            binding.labelRes = label
        }
    }

}