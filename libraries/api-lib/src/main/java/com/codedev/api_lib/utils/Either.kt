package com.codedev.api_lib.utils

sealed class Either<E, R> {
    data class Response<E, R>(val response: R): Either<E, R>()
    data class Error<E, R>(val error: E): Either<E, R>()
}