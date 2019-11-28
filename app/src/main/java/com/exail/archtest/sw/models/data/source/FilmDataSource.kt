package com.exail.archtest.sw.models.data.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.exail.archtest.core.network.ApiResult
import com.exail.archtest.sw.getIdFromUrl
import com.exail.archtest.sw.models.Film
import com.exail.archtest.sw.repository.StarWarsRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class FilmDataSource (
    private val starWarsRepository: StarWarsRepository,
    private val searchQuery: String?
) : PageKeyedDataSource<Int, Film>() {

    val initialLoading = MutableLiveData<Boolean>()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Film>
    ) {
        GlobalScope.launch {
            initialLoading.postValue(true)
            when (val result = starWarsRepository.getFilms(1, searchQuery)) {
                is ApiResult.Success -> {
                    val previous = getIdFromUrl(result.data.previous)
                    val next = getIdFromUrl(result.data.next)
                    callback.onResult(
                        result.data.results,
                        if (previous > -1) previous else null,
                        if (next > -1) next else null
                    )
                }
                is ApiResult.Empty -> {
                    callback.onResult(emptyList<Film>(), 1, 2)
                }
                is ApiResult.Error -> {
                    Timber.e("Initial load error")
                }
            }
            initialLoading.postValue(false)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Film>) {
        GlobalScope.launch {
            when (val result = starWarsRepository.getFilms(params.key, searchQuery)) {
                is ApiResult.Success -> {
                    val next = getIdFromUrl(result.data.next)
                    callback.onResult(
                        result.data.results,
                        if (next > -1) next else null
                    )
                }
                is ApiResult.Empty -> {
                    callback.onResult(emptyList<Film>(), params.key)
                }
                is ApiResult.Error -> {
                    Timber.e( "After load error")
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Film>) {
        GlobalScope.launch {
            when (val result = starWarsRepository.getFilms(params.key, searchQuery)) {
                is ApiResult.Success -> {
                    val previous = getIdFromUrl(result.data.previous)
                    callback.onResult(
                        result.data.results,
                        if (previous > -1) previous else null
                    )
                }
                is ApiResult.Empty -> {
                    callback.onResult(emptyList<Film>(), params.key)
                }
                is ApiResult.Error -> {
                    Timber.e("Before load error")
                }
            }
        }
    }
}