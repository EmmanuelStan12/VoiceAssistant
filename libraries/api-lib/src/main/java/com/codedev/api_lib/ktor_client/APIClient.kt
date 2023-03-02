package com.codedev.api_lib.ktor_client

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


object APIClient {

    operator fun invoke(): HttpClient {
        return HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }

            HttpResponseValidator {
                validateResponse { r ->
//                    when(r.status.value) {
//                        400 -> throw r.body<T>()
//                        401 -> throw r.body<T>()
//                        404 -> throw r.body<T>()
//                    }
                }
            }

            defaultRequest {
                contentType(ContentType.Application.Json)
            }
        }
    }

}