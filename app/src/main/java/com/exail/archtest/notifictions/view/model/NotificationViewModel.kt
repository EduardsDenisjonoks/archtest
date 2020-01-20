package com.exail.archtest.notifictions.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationViewModel : ViewModel(){

    val oNotificationTitle = MutableLiveData<String>()
    val oNotificationContent = MutableLiveData<String>()


    fun getNotificationTitle() = oNotificationTitle.value ?: ""

    fun getNotificationContent() = oNotificationContent.value ?: ""
}