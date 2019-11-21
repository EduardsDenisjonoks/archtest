package com.exail.archtest.core.network

import com.exail.archtest.core.error.*

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
sealed class ApiResult<out T> {

    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Empty(val value: String = "no response") : ApiResult<Nothing>()
    data class Error(val appError: AppError) : ApiResult<Nothing>()

    companion object {
        fun <T> success(data: T): ApiResult<T> = Success(data)
        fun empty() = Empty()
        fun error(
            errorBody: Any,
            vararg errorResolvers: AppErrorResolver = arrayOf(NetworkErrorResolver())
        ): ApiResult<Nothing> = Error(errorResolvers.resolveError(errorBody))
    }
}