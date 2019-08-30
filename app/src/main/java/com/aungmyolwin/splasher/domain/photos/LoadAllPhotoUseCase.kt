package com.aungmyolwin.splasher.domain.photos

import com.aungmyolwin.splasher.data.photos.PhotoRepository

/**
 * a touch of aungmyolwin on 2019-08-28.
 * made with <3
 */
class LoadAllPhotoUseCase(
        private val repository: PhotoRepository
) {
    suspend fun execute() = repository.getAllPhotos();
}