package com.exail.archtest.core

import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import timber.log.Timber

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */

@BindingAdapter("url")
fun AppCompatImageView.loadUrl(url: String?) {
    try {
        when {
            url.isNullOrBlank() -> this.clearImage()
            else -> Picasso.get().load(url).fit().centerCrop().into(this)
        }
    } catch (ex: Exception) {
        Timber.e(ex, "Unable to load url")
    }
}

@BindingAdapter("is_gone")
fun View.isGone(isGone: Boolean = false) {
    visibility = if (isGone) View.GONE else View.VISIBLE
}

@BindingAdapter("integer")
fun AppCompatTextView.setInt(value: Int?) {
    text = value?.toString() ?: ""
}

@BindingAdapter("resource")
fun AppCompatTextView.setRes(@StringRes value: Int?) {
    text = when (value) {
        null -> null
        -1 -> null
        else -> context.getString(value)
    }
}

@BindingAdapter("imageRes")
fun AppCompatImageView.setIntRes(@DrawableRes res: Int?) {
    try {
        when(res) {
            null -> this.clearImage()
            -1 -> this.clearImage()
            else ->  Picasso.get().load(res).into(this)
        }
    } catch (ex: Exception) {
        Timber.e(ex, "Unable to load image res")
    }
}
