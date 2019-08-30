package com.aungmyolwin.splasher.di

import com.aungmyolwin.splasher.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * a touch of aungmyolwin on 2019-08-30.
 * made with <3
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity


}