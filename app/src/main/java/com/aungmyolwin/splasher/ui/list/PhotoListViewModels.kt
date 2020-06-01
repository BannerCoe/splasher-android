package com.aungmyolwin.splasher.ui.list

import androidx.lifecycle.ViewModel
import androidx.paging.Config
import androidx.paging.toLiveData
import com.aungmyolwin.splasher.api.ApiService
import com.aungmyolwin.splasher.data.photos.PhotoRemotePagingDataSourceFactory
import javax.inject.Inject

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class PhotoListViewModels @Inject constructor(api: ApiService) : ViewModel() {

    private val photoRemotePagingDataSourceFactory = PhotoRemotePagingDataSourceFactory(api)
    private val pagingConfig = Config(20, 60)
    val photos = photoRemotePagingDataSourceFactory.toLiveData(pagingConfig, 0)


    fun refresh() = photoRemotePagingDataSourceFactory.photoRemotePagingDataSource.invalidate()

}