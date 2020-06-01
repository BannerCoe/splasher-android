package com.aungmyolwin.splasher.api

import com.aungmyolwin.splasher.vo.Photo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

interface ApiService {
    @GET("/photos")
    fun getPhoto(@Query("client_id") clientId: String, @Query("per_page") perPage: Int = 20, @Query("page") page: Int): Call<List<Photo>>
}