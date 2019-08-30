package com.aungmyolwin.splasher.provider

import com.aungmyolwin.splasher.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * a touch of aungmyolwin on 2019-08-28.
 * made with <3
 */

fun provideOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY

    val httpClient = OkHttpClient.Builder()

    httpClient.addInterceptor(logging)
    return httpClient.build()
}

fun providePhotoApiService(client: OkHttpClient): ApiService {
    val baseUrl = "https://api.unsplash.com/"
    val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    return retrofit.create(ApiService::class.java)
}