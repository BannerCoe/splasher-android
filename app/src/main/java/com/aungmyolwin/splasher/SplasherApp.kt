package com.aungmyolwin.splasher

import android.app.Application
import com.aungmyolwin.splasher.di.networkModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import timber.log.Timber

/**
 * a touch of AungMyoLwin on 8/7/18.
 *     made with <3
 */

class SplasherApp : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        import(networkModule)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}