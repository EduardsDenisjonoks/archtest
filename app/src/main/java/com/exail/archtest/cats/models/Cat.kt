package com.exail.archtest.cats.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */

@Parcelize
data class Cat(
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("url")
    val imageUrl: String
) : Parcelable