package com.exail.archtest.core

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import timber.log.Timber
import java.lang.Exception

fun View.navigateTo(@IdRes destination: Int) {
    try {
        Navigation.findNavController(this).navigate(destination)
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