package com.aungmyolwin.splasher.data.photos

import javax.inject.Inject

/**
 * a touch of aungmyolwin on 2019-08-28.
 * made with <3
 */
class PhotoRepositoryImpl @Inject constructor(
        private val remoteDataSource: PhotoRemoteDataSource
) : PhotoRepository {

    override suspend fun getAllPhotos(clientId: String) = remoteDataSource.getAllPhotos(clientId)
}