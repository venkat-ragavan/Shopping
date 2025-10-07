package com.vrrv.work.onlineshopping.store.data.mapper

import coil.network.HttpException
import com.vrrv.work.onlineshopping.store.domain.model.ApiError
import com.vrrv.work.onlineshopping.store.domain.model.NetworkError
import okio.IOException

fun Throwable.toNetworkError(): NetworkError{
    val error = when (this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        t = this
    )
}