package com.aungmyolwin.splasher.di

import com.aungmyolwin.splasher.ui.list.PhotoListModule
import com.aungmyolwin.splasher.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * a touch of aungmyolwin on 2019-08-30.
 * made with <3
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [
        PhotoListModule::class
    ])
    internal abstract fun contributeMainActivity(): MainActivity


}