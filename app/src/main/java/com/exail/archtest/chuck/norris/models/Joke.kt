package com.exail.archtest.chuck.norris.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by eduardsdenisjonoks  on 2019-05-22.
 */
@Parcelize
data class Joke(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("joke")
    val joke: String
) : Parcelable