package com.codedev.api_lib.utils

import io.ktor.client.plugins.*

sealed class Failure(e: Exception): Exception(e.message) {
    class HttpErrorInternalServerError(e: Exception): Failure(e)
    class GenericError(e: Exception): Failure(e)
    class HttpErrorBadRequest(e: Exception): Failure(e)
    class HttpErrorUnauthorized(e: Exception): Failure(e)
    class HttpErrorForbidden(e: Exception): Failure(e)
    class HttpErrorNotFound(e: Exception): Failure(e)
    class HttpError(e: Exception): Failure(e)
}

fun Exception.catchExceptions() = when(this) {
    is ServerResponseException -> Failure.HttpErrorInternalServerError(this)
    is ClientRequestException -> {
        when(this.response.status.value) {
            400 -> Failure.HttpErrorBadRequest(this)
            401 -> Failure.HttpErrorUnauthorized(this)
            403 -> Failure.HttpErrorForbidden(this)
            404 -> Failure.HttpErrorNotFound(this)
            else -> Failure.HttpError(this)
        }
    }
    is RedirectResponseException -> Failure.HttpError(this)
    else -> Failure.GenericError(this)
}