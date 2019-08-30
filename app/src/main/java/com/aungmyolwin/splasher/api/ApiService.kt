package com.aungmyolwin.splasher.api

import com.aungmyolwin.splasher.vo.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

interface ApiService {
    @GET("/photos")
    suspend fun getPhoto(@Query("client_id") clientId: String): Response<List<Photo>>
}