package com.exail.archtest.cats.repository

import com.exail.archtest.cats.models.Cat
import com.exail.archtest.core.network.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
interface CatRepository {
    suspend fun getCatList(): ApiResult<List<Cat>>

    fun getPaginatedCatList(limit: Int, page: Int): Call<List<Cat>>
}

class CatRepositoryImpl(private val catApi: CatApi) : CatRepository {

    override suspend fun getCatList(): ApiResult<List<Cat>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = catApi.getCats(limit = 30)
                if (response.isSuccessful){
                    ApiResult.success(response.body() ?: emptyList())
                } else {
                    ApiResult.error(response)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }

    override fun getPaginatedCatList(limit: Int, page: Int) = catApi.getPaginatedCats(limit = limit, page = page)

}