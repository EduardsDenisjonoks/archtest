package com.exail.archtest.cats.view.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exail.archtest.cats.models.Cat
import com.exail.archtest.cats.repository.CatRepository
import com.exail.archtest.core.custom.SingleLiveEvent
import com.exail.archtest.core.network.ApiResult
import com.exail.archtest.core.network.ErrorEntity
import kotlinx.coroutines.*
/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
class CatViewModel(private val  catRepository: CatRepository) : ViewModel() {

    val showLoading = MutableLiveData<Boolean>()
    val catsList = MutableLiveData<List<Cat>>()
    val showError = SingleLiveEvent<String>()

    init {
        loadCats()
    }

    fun loadCats() {
        showLoading.value = true
        viewModelScope.launch {
            val result =  catRepository.getCatList()
            showLoading.value = false
            when (result) {
                is ApiResult.Success -> catsList.value = result.data
                is ApiResult.Error -> {
                    when(val errorResult = result.error) {
                        is ErrorEntity.Unknown -> showError.value = errorResult.originalException.localizedMessage
                    }
                }
            }
        }
    }
}