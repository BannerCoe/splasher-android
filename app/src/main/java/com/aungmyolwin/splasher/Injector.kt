package com.aungmyolwin.splasher

import androidx.lifecycle.ViewModelProvider
import com.aungmyolwin.splasher.api.ApiClient
import com.aungmyolwin.splasher.api.ApiService
import com.aungmyolwin.splasher.repository.PhotoRepository
import com.aungmyolwin.splasher.viewmodel.SplasherViewModelFactory

/**
 * a touch of AungMyoLwin on 8/7/18.
 *     made with <3
 */

object Injector {

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return SplasherViewModelFactory(provideRepository())
    }

    private fun provideRepository(): PhotoRepository {
        return PhotoRepository(provideApiService())
    }

    private fun provideApiService(): ApiService {
        return ApiClient.create()
    }
}