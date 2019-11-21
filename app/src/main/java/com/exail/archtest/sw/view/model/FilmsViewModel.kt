package com.exail.archtest.sw.view.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.exail.archtest.sw.models.Film
import com.exail.archtest.sw.models.data.factroy.FilmDataFactory
import com.exail.archtest.sw.repository.StarWarsRepository
import java.util.concurrent.Executors

class FilmsViewModel(val starWarsRepository: StarWarsRepository) : ViewModel() {

    private val executor = Executors.newFixedThreadPool(5)
    private var factory = FilmDataFactory(starWarsRepository, null)

    val search = MutableLiveData<String>()
    val showLoading: LiveData<Boolean>
    val filmList: LiveData<PagedList<Film>>


    init {
        showLoading = Transformations.switchMap(factory.filmLiveData) { filmDataSource ->  filmDataSource.initialLoading }

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(10)
            .build()
        filmList = (LivePagedListBuilder(factory, config)).setFetchExecutor(executor).build()
    }

    fun setSearchQuery(searchQuery: String?){
        factory.setSearchQuery(searchQuery)
    }

    fun refreshData(){
        factory.refresh()
    }

    override fun onCleared() {
        super.onCleared()
        executor.shutdownNow()
    }
}