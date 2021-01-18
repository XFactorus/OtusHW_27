package com.vladp.otusmultiapp.shared.network

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import com.vladp.otusmultiapp.shared.httpClientEngine
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.*
import io.ktor.http.*

class NetworkService {

    val httpClient = HttpClient(httpClientEngine) {

        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
        }

        install(JsonFeature) {
            accept(ContentType.Text.JavaScript)
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend inline fun <reified T> loadData(url: String): T? {
        return httpClient.get(url)
    }

}