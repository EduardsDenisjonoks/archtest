package com.exail.archtest.cats.repository

import com.exail.archtest.cats.models.Cat
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
interface CatApi {
    @GET("images/search")
    suspend fun getCats(@Query("limit") limit: Int): Response<List<Cat>>

    @GET("images/search")
    fun getPaginatedCats(@Query("limit") limit: Int, @Query("page") page: Int): Call<List<Cat>>
}