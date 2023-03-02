package com.codedev.data_lib.util

sealed class Resource<T>(
    val data: T? = null,
    val error: String? = null,
    val loading: Boolean = false
) {
    class Loading<T>: Resource<T>(loading = true)
    class Error<T>(error: String): Resource<T>(loading = false, error = error)
    class Success<T>(data: T): Resource<T>(loading = false, data = data)
}
