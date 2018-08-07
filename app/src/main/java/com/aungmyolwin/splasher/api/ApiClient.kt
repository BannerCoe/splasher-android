package com.aungmyolwin.splasher.api

import com.aungmyolwin.splasher.utils.LiveDataCallAdapterFactory
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

/**
 * a touch of AungMyoLwin on 8/7/18.
 *     made with <3
 */

class ApiClient {
    companion object {
        private const val BASE_URL = "https://api.unsplash.com/"
        fun create(): ApiService = create(HttpUrl.parse(BASE_URL)!!)

        private val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Timber.d("API $it")
        })


        fun create(httpUrl: HttpUrl): ApiService {
            logger.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()

            return Retrofit.Builder()
                    .baseUrl(httpUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(LiveDataCallAdapterFactory())
                    .build()
                    .create(ApiService::class.java)
        }


    }
}