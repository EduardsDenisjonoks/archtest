package com.exail.archtest.core.network

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
sealed class ApiResult<out T : Any> {
    class Success<out T : Any>(val data: T) : ApiResult<T>()
    class Error(val error: ErrorEntity) : ApiResult<Nothing>()
}

sealed class ErrorEntity {

    abstract val originalException: Throwable

    data class Network(override val originalException: Throwable) : ErrorEntity()

    data class NotFound(override val originalException: Throwable) : ErrorEntity()

    data class AccessDenied(override val originalException: Throwable) : ErrorEntity()

    data class ServiceUnavailable(override val originalException: Throwable) : ErrorEntity()

    data class Unknown(override val originalException: Throwable) : ErrorEntity()
}