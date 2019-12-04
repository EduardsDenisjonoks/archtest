package com.exail.archtest.core.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import com.exail.archtest.core.Analytics
import org.koin.android.ext.android.inject

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    val analytics by inject<Analytics> ()
}