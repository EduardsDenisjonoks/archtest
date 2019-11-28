package com.exail.archtest.cats.models.data.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.exail.archtest.cats.models.Cat
import com.exail.archtest.cats.repository.CatRepository


/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
class CatDataFactory(private val catRepository: CatRepository) : DataSource.Factory<Int, Cat>() {

    val catLiveData = MutableLiveData<CatDataSource>()

    override fun create(): DataSource<Int, Cat> {
        val catDataSource = CatDataSource(catRepository)
        catLiveData.postValue(catDataSource)
        return catDataSource
    }

    fun refresh(){
        catLiveData.value?.invalidate()
    }
}