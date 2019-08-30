package com.aungmyolwin.splasher.di

import com.aungmyolwin.splasher.SplasherApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * a touch of aungmyolwin on 2019-08-30.
 * made with <3
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    AppModule::class,
    ViewModelModule::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<SplasherApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<SplasherApp>()
}