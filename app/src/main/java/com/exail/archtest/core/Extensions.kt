package com.exail.archtest.core

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.squareup.picasso.Picasso
import timber.log.Timber
import java.lang.Exception

//region NAVIGATION
fun View.navigateTo(@IdRes destination: Int, bundle: Bundle? = null) {
    try {
        Navigation.findNavController(this).navigate(destination, bundle)
    } catch (ex: Exception) {
        Timber.e(ex, "Unable to navigate from this view")
    }
}

fun View.navigateTo(navDirections: NavDirections) {
    try {
        Navigation.findNavController(this).navigate(navDirections)
    } catch (ex: Exception) {
        Timber.e(ex, "Unable to navigate from this view")
    }
}

fun View.navigatePopUpTo(@IdRes destination: Int, inclusive: Boolean = true) {
    try {
        Navigation.findNavController(this).popBackStack(destination, inclusive)
    } catch (ex: Exception) {
        Timber.e(ex, "Unable to pop up to from this view")
    }
}

fun View.navigatePopUp() {
    try {
        Navigation.findNavController(this).popBackStack()
    } catch (ex: Exception) {
        Timber.e(ex, "Unable to pop up from this view")
    }
}


fun Fragment.navigateTo(@IdRes destination: Int) {
    try {
        NavHostFragment.findNavController(this).navigate(destination)
    } catch (ex: Exception) {
        Timber.e(ex, "Unable to navigate from this fragment")
    }
}

fun AppCompatActivity.navigateTo(@IdRes host: Int, @IdRes destination: Int) {
    try {
        Navigation.findNavController(this, host).navigate(destination)
    } catch (ex: Exception) {
        Timber.e(ex, "Unable to navigate from this activity")
    }
}
//endregion

//region IMAGE VIEW
fun AppCompatImageView.clearImage() {
    try {
        Picasso.get().cancelRequest(this)
    } catch (ex: Exception) {
        Timber.e(ex, "Failed to cancel picasso request")
    } finally {
        this.setImageDrawable(null)
    }
}
//endregion

//region LIVE DATA
fun <T> LiveData<T>.getDistinct(): LiveData<T> {
    val distinctLiveData = MediatorLiveData<T>()
    distinctLiveData.addSource(this, object : Observer<T> {
        private var initialized = false
        private var lastObj: T? = null
        override fun onChanged(obj: T?) {
            if (!initialized) {
                initialized = true
                lastObj = obj
                distinctLiveData.postValue(lastObj)
            } else if ((obj == null && lastObj != null)
                || obj != lastObj) {
                lastObj = obj
                distinctLiveData.postValue(lastObj)
            }
        }
    })
    return distinctLiveData
}
//endregion