package com.aungmyolwin.splasher.api

import androidx.lifecycle.LiveData
import com.aungmyolwin.splasher.vo.Photo
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

interface ApiService {
    @GET("/photos")
    fun getPhoto(@Query("client_id") clientId: String): LiveData<ApiResponse<List<Photo>>>
}