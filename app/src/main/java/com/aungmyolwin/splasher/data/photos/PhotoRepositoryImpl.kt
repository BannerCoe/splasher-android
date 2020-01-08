package com.aungmyolwin.splasher.data.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.aungmyolwin.splasher.vo.Photo
import com.aungmyolwin.splasher.vo.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * a touch of aungmyolwin on 2019-08-28.
 * made with <3
 */

interface PhotoRepository {
    suspend fun getAllPhotos(clientId: String): LiveData<Result<List<Photo>>>
}

class PhotoRepositoryImpl @Inject constructor(
        private val remoteDataSource: PhotoRemoteDataSource
) : PhotoRepository {
    override suspend fun getAllPhotos(clientId: String): LiveData<Result<List<Photo>>> {
        return liveData {

            emit(Result.Loading)

            val response = withContext(Dispatchers.IO) {
                remoteDataSource.getAllPhotos(clientId)
            }

            if (response.isSuccessful && response.code() == 200) {
                emit(Result.Success(response.body() ?: emptyList()))
            } else {
                emit(Result.Error(Exception(response.code().toString())))
            }
        }
    }
}