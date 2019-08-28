package com.aungmyolwin.splasher.di

import com.aungmyolwin.splasher.api.ApiService
import com.aungmyolwin.splasher.provider.provideOkHttpClient
import com.aungmyolwin.splasher.provider.providePhotoApiService
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import org.kodein.di.generic.with

/**
 * a touch of aungmyolwin on 2019-08-28.
 * made with <3
 */

private const val TAG_SERVER_URL = "server_url_const"
val networkModule = Kodein.Module("network-module") {
    constant(TAG_SERVER_URL) with Consts.SERVER_URL
    bind<OkHttpClient>() with singleton { provideOkHttpClient() }
    bind<ApiService>() with singleton { providePhotoApiService(instance(), instance(TAG_SERVER_URL)) }
}