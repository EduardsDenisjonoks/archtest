package com.exail.archtest.sw.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.exail.archtest.R
import com.exail.archtest.databinding.SwItemFilmDetailsBinding
import com.exail.archtest.databinding.SwItemLabelBinding
import com.exail.archtest.databinding.SwItemTitleBinding
import com.exail.archtest.databinding.SwItemDescriptionBinding
import com.exail.archtest.sw.models.Film
import com.exail.archtest.sw.releaseDateToDateString

class FilmAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val title = 0
    private val details = 1
    private val description = 2
    private val other = 3

    private var film: Film? = null

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> title
            1 -> details
            2 -> description
            else -> other
        }
    }

    override fun getItemCount() = if (film == null) 0 else 8

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        when (viewType) {
            title -> return SwTitle(
                DataBindingUtil.inflate(
                    inflater,
                    R.layout.sw_item_title,
                    parent,
                    false
                )
            )
            details -> return SwDetails(
                DataBindingUtil.inflate(
                    inflater,
                    R.layout.sw_item_film_details,
                    parent,
                    false
                )
            )
            description -> return SwDescription(
                DataBindingUtil.inflate(
                    inflater,
                    R.layout.sw_item_description,
                    parent,
                    false
                )
            )
            else -> return SwItem(
                DataBindingUtil.inflate(
                    inflater,
                    R.layout.sw_item_label,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SwTitle -> holder.bindView(film?.title)
            is SwDetails -> holder.bindView(film)
            is SwDescription -> holder.bindView(film?.openingCrawl)
            is SwItem -> holder.bindView(film)
        }
    }

    fun setFilm(film: Film?){
        this.film = film
        notifyDataSetChanged()
    }

    class SwTitle(val binding: SwItemTitleBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(title: String?) {
            binding.title = title
        }
    }

    class SwDetails(val binding: SwItemFilmDetailsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(film: Film?) {
            binding.director = film?.director
            binding.producer = film?.producer
            binding.episode = film?.episodeId.toString()
            binding.date = releaseDateToDateString(film?.releaseDate)
        }
    }

    class SwDescription(val binding: SwItemDescriptionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(description: String?) {
            binding.description = description
        }
    }

    class SwItem(val binding: SwItemLabelBinding) : RecyclerView.ViewHolder(binding.root) {

        private var film : Film? = null

        //todo click listener with navigation

        fun bindView(film: Film?){
            this.film = film
            binding.labelRes = when(adapterPosition - 3){
                0 -> R.string.sw_people
                1 -> R.string.sw_star_ships
                2 -> R.string.sw_vehicles
                3 -> R.string.sw_species
                4 -> R.string.sw_planets
                else -> -1
            }
        }
    }
}