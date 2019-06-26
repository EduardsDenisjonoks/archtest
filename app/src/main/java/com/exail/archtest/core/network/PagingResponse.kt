package com.exail.archtest.core.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by eduardsdenisjonoks  on 2019-06-05.
 */
data class PagingResponse<T> (
    @Expose
    @SerializedName("count")
    val count : Int,
    @Expose
    @SerializedName("next")
    val next : String?,
    @Expose
    @SerializedName("previous")
    val previous : String?,
    @Expose
    @SerializedName("results")
    val results : List<T> = emptyList()
)