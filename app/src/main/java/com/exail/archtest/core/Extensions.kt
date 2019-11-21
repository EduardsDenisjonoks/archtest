package com.exail.archtest.core

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import timber.log.Timber
import java.lang.Exception

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