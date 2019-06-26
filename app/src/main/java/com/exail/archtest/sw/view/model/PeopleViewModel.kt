package com.exail.archtest.sw.view.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
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
    private lateinit var factory : DataSource.Factory<Int, People>

    val search = MutableLiveData<String>()
    val peopleList: LiveData<PagedList<People>>


    init {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(10)
            .build()
        peopleList = initPagedListBuilder(search.value, config).build()
    }

    private fun initPagedListBuilder(string: String?, config:  PagedList.Config):  LivePagedListBuilder<Int,People>{
        factory = PeopleDataFactory(starWarsRepository, string)
        return LivePagedListBuilder<Int, People>(factory, config)
    }


    fun refreshData(){

    }

    override fun onCleared() {
        super.onCleared()
        executor.shutdownNow()
    }
}