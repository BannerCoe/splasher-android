package com.aungmyolwin.splasher.repository

import androidx.lifecycle.LiveData
import com.aungmyolwin.splasher.api.ApiResponse
import com.aungmyolwin.splasher.api.ApiService
import com.aungmyolwin.splasher.utils.AbsentLiveData
import com.aungmyolwin.splasher.utils.NetworkBoundResource
import com.aungmyolwin.splasher.vo.Photo
import com.aungmyolwin.splasher.vo.Resource

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class PhotoRepository(private val apiService: ApiService) {
    init {

    }

    fun loadPhoto(clientId: String): LiveData<Resource<List<Photo>>> {
        return object : NetworkBoundResource<List<Photo>, List<Photo>>() {
            override fun saveCallResult(item: List<Photo>) {
            }

            override fun shouldFetch(data: List<Photo>?): Boolean = true

            override fun loadFromDb(): LiveData<List<Photo>> = AbsentLiveData.create()

            override fun createCall(): LiveData<ApiResponse<List<Photo>>> = apiService.getPhoto(clientId)

            override fun shouldSaveFetchedData(): Boolean = false

        }.asLiveData()
    }
}