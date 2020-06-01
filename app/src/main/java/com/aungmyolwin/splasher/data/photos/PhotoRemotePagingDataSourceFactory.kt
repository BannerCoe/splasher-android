package com.aungmyolwin.splasher.data.photos

import androidx.paging.DataSource
import com.aungmyolwin.splasher.api.ApiService
import com.aungmyolwin.splasher.vo.Photo
import javax.inject.Inject

/**
 * a touch of amlwin on 01/06/2020.
 * made with <3
 */

class PhotoRemotePagingDataSourceFactory @Inject constructor(private val api: ApiService) : DataSource.Factory<Int, Photo>() {
    lateinit var photoRemotePagingDataSource: PhotoRemotePagingDataSource
    override fun create(): DataSource<Int, Photo> {
        photoRemotePagingDataSource = PhotoRemotePagingDataSource(api)
        return photoRemotePagingDataSource
    }
}