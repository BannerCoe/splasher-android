package com.aungmyolwin.splasher.data.photos

import com.aungmyolwin.splasher.api.ApiService
import com.aungmyolwin.splasher.vo.Photo
import com.aungmyolwin.splasher.vo.Result

/**
 * a touch of aungmyolwin on 2019-08-28.
 * made with <3
 */
class PhotoRemoteDataSource constructor(
        private val apiService: ApiService
) {
    suspend fun getAllPhotos(clientId: String): com.aungmyolwin.splasher.vo.Result<List<Photo>> {
        val response = apiService.getPhoto(clientId)
        if (response.isSuccessful) {
            return Result.Success(response.body() ?: mutableListOf())
        } else {
            return Result.Error(exception = Exception(response.message()))
        }
    }

}