package com.exail.archtest.sw.view.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exail.archtest.R
import com.exail.archtest.sw.models.Film
import com.exail.archtest.sw.models.def.FilmEpisode

class FilmViewModel(val film : Film?) : ViewModel() {

    val filmPoster : LiveData<Int>


    init {
        filmPoster = MutableLiveData<Int>().apply { value = getFilmPoster(film) }
    }

    private fun getFilmPoster(film: Film?) = when (film?.episodeId) {
        FilmEpisode.EPISODE_ONE -> R.drawable.episode_one
        FilmEpisode.EPISODE_TWO -> R.drawable.episode_two
        FilmEpisode.EPISODE_THREE -> R.drawable.episode_three
        FilmEpisode.EPISODE_FOUR -> R.drawable.episode_four
        else -> -1
    }


}