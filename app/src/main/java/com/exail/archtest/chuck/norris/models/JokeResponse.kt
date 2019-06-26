package com.exail.archtest.chuck.norris.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by eduardsdenisjonoks  on 2019-05-22.
 */
@Parcelize
data class JokeResponse(
    @Expose
    @SerializedName("type")
    val type: String,
    @Expose
    @SerializedName("value")
    val joke: Joke?
) : Parcelable