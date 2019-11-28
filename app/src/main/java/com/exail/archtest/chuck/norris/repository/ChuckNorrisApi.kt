package com.exail.archtest.chuck.norris.repository

import com.exail.archtest.chuck.norris.models.JokeResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by eduardsdenisjonoks  on 2019-05-22.
 */
interface ChuckNorrisApi {

    @GET("jokes/random")
    suspend fun getRandomJoke(): Response<JokeResponse>
}