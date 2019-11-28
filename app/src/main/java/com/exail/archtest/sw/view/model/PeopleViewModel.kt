package com.exail.archtest.sw.view.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.exail.archtest.sw.models.People
import com.exail.archtest.sw.models.data.factroy.PeopleDataFactory
import com.exail.archtest.sw.repository.StarWarsRepository
import java.util.concurrent.Executors

/**
 * Created by eduardsdenisjonoks  on 2019-06-06.
 */
class PeopleViewModel(val starWarsRepository: StarWarsRepository) : ViewModel() {

    private val executor = Executors.newFixedThreadPool(5)
    private var factory = PeopleDataFactory(starWarsRepository, null)

    val search = MutableLiveData<String>()
    val showLoading: LiveData<Boolean>
    val peopleList: LiveData<PagedList<People>>


    init {
        showLoading = Transformations.switchMap(factory.peopleLiveData) { peopleDataSource ->  peopleDataSource.initialLoading }

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(10)
            .build()
        peopleList = (LivePagedListBuilder(factory, config)).setFetchExecutor(executor).build()
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