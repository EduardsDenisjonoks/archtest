package com.exail.archtest.sw.models.data.factroy

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.exail.archtest.cats.models.data.source.CatDataSource
import com.exail.archtest.sw.models.People
import com.exail.archtest.sw.models.data.source.PeopleDataSource
import com.exail.archtest.sw.repository.StarWarsRepository
import retrofit2.http.Query

/**
 * Created by eduardsdenisjonoks  on 2019-06-06.
 */
class PeopleDataFactory(
    private val starWarsRepository: StarWarsRepository,
    private val searchQuery: String?
) : DataSource.Factory<Int, People>() {


    val peopleLiveData = MutableLiveData<PeopleDataSource>()

    override fun create(): DataSource<Int, People> {
        val peopleDataSource = PeopleDataSource(starWarsRepository, searchQuery)
        peopleLiveData.postValue(peopleDataSource)
        return peopleDataSource
    }


}