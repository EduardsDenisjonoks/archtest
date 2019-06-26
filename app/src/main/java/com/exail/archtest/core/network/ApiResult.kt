package com.exail.archtest.core.network

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
sealed class ApiResult<out T : Any> {
    class Success<out T : Any>(val data: T) : ApiResult<T>()
    class Error(val exception: Throwable) : ApiResult<Nothing>()
}