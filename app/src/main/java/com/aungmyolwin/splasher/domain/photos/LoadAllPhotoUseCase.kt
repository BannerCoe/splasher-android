package com.aungmyolwin.splasher.domain.photos

import com.aungmyolwin.splasher.data.photos.PhotoRepositoryImpl
import javax.inject.Inject

/**
 * a touch of aungmyolwin on 2019-08-28.
 * made with <3
 */
class LoadAllPhotoUseCase @Inject constructor(
        private val repository: PhotoRepositoryImpl
) {
    suspend fun execute() = repository.getAllPhotos()
}