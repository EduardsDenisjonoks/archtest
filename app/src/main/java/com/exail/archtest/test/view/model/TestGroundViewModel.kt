package com.exail.archtest.test.view.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * Created by eduardsdenisjonoks  on 2019-05-29.
 */
class TestGroundViewModel : ViewModel() {

    val entries = listOf("Apple", "Dog", "Cat", "Mice", "Orange", "Banana", "Hamster")
    val selectedItem = MutableLiveData<Int>()
    val userText = MutableLiveData<String>()
    val selectedItemText : LiveData<String>

    init {
        selectedItemText = Transformations.map(selectedItem) { index -> index?.let{entries[index]} }
    }


    fun plus() {
        when(val value = selectedItem.value?.plus(1) ?: 0){
            in 0 until entries.size -> selectedItem.value = value
            else -> selectedItem.value = entries.size -1
        }
    }

    fun minus() {
        when(val value = selectedItem.value?.minus(1) ?: 0) {
            in 0 until entries.size -> selectedItem.value = value
            else -> selectedItem.value = 0
        }
    }

    fun updateUserText(value: Int = 0){
        when(value){
            in 0 until entries.size -> userText.value = entries[value]
        }
    }
}