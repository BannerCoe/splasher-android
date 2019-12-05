package com.aungmyolwin.splasher.data.photos

import com.aungmyolwin.splasher.vo.Photo
import com.aungmyolwin.splasher.vo.Result

/**
 * a touch of aungmyolwin on 2019-08-28.
 * made with <3
 */
interface PhotoRepository {
    suspend fun getAllPhotos(clientId: String): Result<List<Photo>>
}