package com.exail.archtest.chuck.norris.repository

import com.exail.archtest.chuck.norris.models.JokeResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * Created by eduardsdenisjonoks  on 2019-05-22.
 */
interface ChuckNorrisApi {

    @GET("jokes/random")
    fun getRandomJoke(): Deferred<JokeResponse>
}