package com.exail.archtest.chuck.norris.repository

import com.exail.archtest.R
import com.exail.archtest.chuck.norris.models.Joke
import com.exail.archtest.core.network.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by eduardsdenisjonoks  on 2019-05-22.
 */
interface ChuckNorrisRepository {
    suspend fun getRandomJoke(): ApiResult<Joke>
}

class ChuckNorrisRepositoryImpl(private val chuckNorrisApi: ChuckNorrisApi) : ChuckNorrisRepository {

    override suspend fun getRandomJoke(): ApiResult<Joke> {
        return withContext(Dispatchers.IO) {
            try {
                val response = chuckNorrisApi.getRandomJoke()
                if (response.isSuccessful){
                    when(val joke = response.body()?.joke){
                        null -> ApiResult.error(R.string.error_no_joke)
                        else -> ApiResult.success(joke)
                    }
                } else {
                    ApiResult.error(response)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }

}