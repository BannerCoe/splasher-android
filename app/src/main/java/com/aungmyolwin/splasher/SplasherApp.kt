package com.aungmyolwin.splasher

import android.app.Application
import timber.log.Timber

/**
 * a touch of AungMyoLwin on 8/7/18.
 *     made with <3
 */

class SplasherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}