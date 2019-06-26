package com.exail.archtest.cats.models.data.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.exail.archtest.cats.models.Cat
import com.exail.archtest.cats.repository.CatRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
class CatDataSource(private val catRepository: CatRepository) : PageKeyedDataSource<Int, Cat>() {

    val initialLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Cat>) {
        initialLoading.postValue(true)
        catRepository.getPaginatedCatList(limit = params.requestedLoadSize, page = 1)
            .enqueue(object : Callback<List<Cat>> {
                override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                    initialLoading.postValue(false)
                    error.postValue(t.message)
                }

                override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                    initialLoading.postValue(false)
                    if (response.isSuccessful) {
                        callback.onResult(response.body() ?: emptyList(), null, 2)
                    } else {
                        error.postValue("Unable to process response, " +
                                "code: ${response.code()}, " +
                                "message: ${response.message()}, " +
                                "error: ${response.errorBody()?.toString()}")
                    }
                }
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Cat>) {
        catRepository.getPaginatedCatList(limit = params.requestedLoadSize, page = params.key)
            .enqueue(object : Callback<List<Cat>> {
                override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                    error.postValue(t.message)
                }

                override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                    if (response.isSuccessful) {
                        callback.onResult(response.body() ?: emptyList(), params.key + 1)
                    } else {
                        error.postValue("Unable to process response, " +
                                "code: ${response.code()}, " +
                                "message: ${response.message()}, " +
                                "error: ${response.errorBody()?.toString()}")
                    }
                }
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Cat>) {
        //no previous loading
    }
}