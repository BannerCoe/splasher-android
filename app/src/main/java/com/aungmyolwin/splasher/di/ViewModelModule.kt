package com.aungmyolwin.splasher.di


import androidx.lifecycle.ViewModelProvider
import com.aungmyolwin.splasher.viewmodel.SplasherViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * a touch of aungmyolwin on 2019-08-30.
 * made with <3
 */
@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun binViewModelFactory(factory: SplasherViewModelFactory): ViewModelProvider.Factory
}