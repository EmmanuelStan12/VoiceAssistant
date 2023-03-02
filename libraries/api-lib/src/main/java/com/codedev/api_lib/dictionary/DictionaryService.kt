package com.codedev.api_lib.dictionary

import com.codedev.api_lib.dictionary.models.DictionaryApiResponse
import com.codedev.api_lib.dictionary.utils.BASE_URL
import com.codedev.api_lib.ktor_client.APIClient
import com.codedev.api_lib.utils.Either
import com.codedev.api_lib.utils.Failure
import com.codedev.api_lib.utils.catchExceptions
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import okhttp3.HttpUrl.Companion.toHttpUrl

class DictionaryService {

    suspend fun searchWord(word: String): Either<Failure, DictionaryApiResponse> {
        val url = "$BASE_URL/$word".toHttpUrl().toUrl()

        return try {
            val response = APIClient.CLIENT.request(url) {
                method = HttpMethod.Get
            }
            val model = response.body<DictionaryApiResponse>()

            Either.Response(model)
        } catch (e: Exception) {
            Either.Error(e.catchExceptions())
        }
    }
}