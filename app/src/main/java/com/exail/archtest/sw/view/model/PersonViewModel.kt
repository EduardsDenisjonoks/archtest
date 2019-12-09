package com.exail.archtest.sw.view.model

import androidx.core.app.Person
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exail.archtest.R
import com.exail.archtest.core.network.ApiResult
import com.exail.archtest.sw.models.People
import com.exail.archtest.sw.repository.StarWarsRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class PersonViewModel(private val person: People?, val startWarsRepository: StarWarsRepository) :
    ViewModel() {

    val personImage: LiveData<Int>
    private val homeworld = MutableLiveData<String>()

    init {
        personImage = MutableLiveData<Int>().apply { value = getPersonImage(person) }
        getHomeworldFromApi()
    }

    fun getPerson() = person

    fun getName(): String? = person?.name

    fun getDob(): String? = person?.birthYear

    fun getHeight(): String? = person?.height

    fun getMass(): String? = person?.mass

    fun getHomeworld(): LiveData<String> = homeworld

    private fun getPersonImage(person: People?) = when (person?.id) {
        else -> R.drawable.luke_skywalker
    }

    private fun getHomeworldFromApi() {
        viewModelScope.launch {
            when (val result = startWarsRepository.getPlanets(person?.homeWorld ?: -1)) {
                is ApiResult.Success -> homeworld.postValue(result.data.name)
                is ApiResult.Error -> {
                    Timber.e("Unable to get homeworld: ${result.appError.errorString}")
                    homeworld.postValue("unknown")
                }
            }
        }
    }

}