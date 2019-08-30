package com.aungmyolwin.splasher.data.photos

import com.aungmyolwin.splasher.api.ApiService
import com.aungmyolwin.splasher.vo.Photo
import com.aungmyolwin.splasher.vo.Result
import javax.inject.Inject

/**
 * a touch of aungmyolwin on 2019-08-28.
 * made with <3
 */
class PhotoRemoteDataSource @Inject constructor(
        private val apiService: ApiService
) {
    suspend fun getAllPhotos(clientId: String): Result<List<Photo>> {
        val response = apiService.getPhoto(clientId)
        return if (response.isSuccessful) {
            Result.Success(response.body() ?: mutableListOf())
        } else {
            Result.Error(exception = Exception(response.message()))
        }
    }

}