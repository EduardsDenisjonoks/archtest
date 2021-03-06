package com.exail.archtest.chuck.norris.view.model

import androidx.lifecycle.*
import com.exail.archtest.chuck.norris.models.Joke
import com.exail.archtest.chuck.norris.repository.ChuckNorrisRepository
import com.exail.archtest.core.custom.SingleLiveEvent
import com.exail.archtest.core.network.ApiResult
import kotlinx.coroutines.launch

/**
 * Created by eduardsdenisjonoks  on 2019-05-22.
 */
class ChuckNorrisViewModel(private val chuckNorrisRepository: ChuckNorrisRepository) : ViewModel() {

    private val joke = MutableLiveData<Joke?>()

    val showLoading = MutableLiveData<Boolean>()
    val showError = SingleLiveEvent<Int>()
    val jokeText: LiveData<String>

    init {
        jokeText = Transformations.map(joke) { input -> input?.joke }
        randomJoke()
    }

    fun randomJoke() {
        showLoading.value = true
        viewModelScope.launch {
            val result = chuckNorrisRepository.getRandomJoke()
            showLoading.value = false
            when (result) {
                is ApiResult.Success -> joke.value = result.data
                is ApiResult.Error -> showError.value = result.appError.errorResource
            }
        }
    }
}