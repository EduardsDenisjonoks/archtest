package com.exail.archtest.sw.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.exail.archtest.R
import com.exail.archtest.databinding.SwItemLabelBinding
import com.exail.archtest.sw.models.People

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.SwItem>() {

    private var person: People? = null

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

    override fun getItemCount() = 4

    override fun onBindViewHolder(holder: SwItem, position: Int) {
       holder.bindView(person)
    }

    fun setPerson(person: People?){
        this.person = person
    }

    class SwItem(val binding: SwItemLabelBinding) : RecyclerView.ViewHolder(binding.root) {

        private var person: People? = null

        //todo click listener with navigation

        fun bindView(person: People?) {
            this.person = person
            binding.labelRes = when (adapterPosition) {
                0 -> R.string.sw_species
                1 -> R.string.sw_star_ships
                2 -> R.string.sw_vehicles
                3 -> R.string.sw_films
                else -> -1
            }
        }
    }

}