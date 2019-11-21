package com.exail.archtest.sw.models.data.factroy

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.exail.archtest.sw.models.Film
import com.exail.archtest.sw.models.data.source.FilmDataSource
import com.exail.archtest.sw.repository.StarWarsRepository

class FilmDataFactory(
    private val starWarsRepository: StarWarsRepository,
    private var searchQuery: String?
) : DataSource.Factory<Int, Film>() {

    val filmLiveData = MutableLiveData<FilmDataSource>()

    override fun create(): DataSource<Int, Film> {
        val filmDataSource = FilmDataSource(starWarsRepository, searchQuery)
        filmLiveData.postValue(filmDataSource)
        return filmDataSource
    }

    fun setSearchQuery(query: String?){
        searchQuery = query
        refresh()
    }

    fun refresh(){
        filmLiveData.value?.invalidate()
    }

}