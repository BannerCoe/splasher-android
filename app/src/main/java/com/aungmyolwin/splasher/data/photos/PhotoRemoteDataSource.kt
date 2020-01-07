package com.aungmyolwin.splasher.data.photos

import com.aungmyolwin.splasher.api.ApiService
import com.aungmyolwin.splasher.vo.Photo
import retrofit2.Response
import javax.inject.Inject

/**
 * a touch of aungmyolwin on 2019-08-28.
 * made with <3
 */

interface PhotoRemoteDataSource {
    suspend fun getAllPhotos(clientId: String): Response<List<Photo>>
}

class PhotoRemoteDataSourceImpl @Inject constructor(
        private val apiService: ApiService
) : PhotoRemoteDataSource {
    override suspend fun getAllPhotos(clientId: String): Response<List<Photo>> {
        return apiService.getPhoto(clientId)
    }

    /*suspend fun getAllPhotos(clientId: String): LiveData<Result<List<Photo>>> {
        return liveData {

            val response = withContext(Dispatchers.IO) {
                apiService.getPhoto(clientId)
            }
            if(response.isSuccessful){
                emit(Result.Success(response.body() ?: emptyList()))
            }else{
                Result.Error(exception = Exception(response.message()))
            }
        }
        *//* val response = apiService.getPhoto(clientId)
         return if (response.isSuccessful) {
             Result.Success(response.body() ?: mutableListOf())
         } else {
             Result.Error(exception = Exception(response.message()))
         }*//*
    }*/

}