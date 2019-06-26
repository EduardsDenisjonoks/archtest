package com.exail.archtest.core

import android.util.Log
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */

@BindingAdapter("url")
fun AppCompatImageView.loadUrl(url: String?) {
    try {
        if (url.isNullOrEmpty()) {
            Picasso.get().cancelRequest(this)
            this.setImageDrawable(null)
        } else {
            Picasso.get().load(url).fit().centerCrop().into(this)
        }
    } catch (ex: Exception) {
        Log.e("AppCompatImageView", "Unable to load url", ex)
    }
}

@BindingAdapter("is_gone")
fun View.isGone(isGone: Boolean = false) {
    visibility = if (isGone) View.GONE else View.VISIBLE
}

@BindingAdapter("is_invisible")
fun View.isInvisible(isInvisible: Boolean = false) {
    visibility = if (isInvisible) View.INVISIBLE else View.VISIBLE
}

@BindingAdapter("integer")
fun AppCompatTextView.setInt(value: Int?) {
    text = value?.toString() ?: ""
}

@BindingAdapter("resource")
fun AppCompatTextView.setRes(@StringRes value: Int?) {
    when (value){
        null -> text = null
        -1 -> text = null
        else -> text = context.getString(value)
    }
}