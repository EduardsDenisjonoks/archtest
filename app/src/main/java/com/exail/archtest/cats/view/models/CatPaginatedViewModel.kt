package com.exail.archtest.cats.view.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.exail.archtest.cats.models.Cat
import com.exail.archtest.cats.models.data.source.CatDataFactory
import com.exail.archtest.cats.repository.CatRepository
import java.util.concurrent.Executors


/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
class CatPaginatedViewModel(catRepository: CatRepository) : ViewModel() {

    private val executor = Executors.newFixedThreadPool(5)
    private val factory = CatDataFactory(catRepository)

    val showLoading: LiveData<Boolean>
    val showError: LiveData<String>
    val catList: LiveData<PagedList<Cat>>

    init {
        showLoading = Transformations.switchMap(factory.catLiveData) { catDataSource ->  catDataSource.initialLoading }
        showError = Transformations.switchMap(factory.catLiveData) { catDataSource ->  catDataSource.error }

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()

        catList =
            (LivePagedListBuilder(factory, pagedListConfig)).setFetchExecutor(executor).build()
    }

    fun refreshData(){
        factory.refresh()
    }

    override fun onCleared() {
        super.onCleared()
        executor.shutdownNow()
    }
}