package com.exail.archtest.cats.view.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exail.archtest.cats.models.Cat
import com.exail.archtest.cats.repository.CatRepository
import com.exail.archtest.core.custom.SingleLiveEvent
import com.exail.archtest.core.network.ApiResult
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
class CatViewModel(private val  catRepository: CatRepository) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    val showLoading = MutableLiveData<Boolean>()
    val catsList = MutableLiveData<List<Cat>>()
    val showError = SingleLiveEvent<String>()

    init {
        loadCats()
    }

    fun loadCats() {
        showLoading.value = true
        launch {
            val result =  catRepository.getCatList()
            showLoading.value = false
            when (result) {
                is ApiResult.Success -> catsList.value = result.data
                is ApiResult.Error -> showError.value = result.exception.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}