package com.aungmyolwin.splasher.di

import android.content.Context
import com.aungmyolwin.splasher.SplasherApp
import dagger.Module
import dagger.Provides

/**
 * a touch of aungmyolwin on 2019-08-30.
 * made with <3
 */
@Module
class AppModule {
    @Provides
    fun provideContext(application: SplasherApp): Context {
        return application.applicationContext
    }
}