package com.aungmyolwin.splasher.ui.list

import androidx.lifecycle.ViewModel
import com.aungmyolwin.splasher.di.FragmentScoped
import com.aungmyolwin.splasher.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * a touch of aungmyolwin on 2019-08-30.
 * made with <3
 */
@Module
abstract class PhotoListModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun providePhotListFragment(): PhotoListFragment

    @Binds
    @IntoMap
    @ViewModelKey(PhotoListViewModels::class)
    internal abstract fun bindPhotoListViewModel(vm: PhotoListViewModels): ViewModel
}