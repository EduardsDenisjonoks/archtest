package com.exail.archtest.chuck.norris.repository

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
                val result = chuckNorrisApi.getRandomJoke().await()
                val joke = result.joke
                if (joke == null){
                    ApiResult.Error(Throwable("Joke data is missing"))
                } else {
                    ApiResult.Success(joke)
                }
            } catch (ex: Exception) {
                ApiResult.Error(ex)
            }
        }
    }

}