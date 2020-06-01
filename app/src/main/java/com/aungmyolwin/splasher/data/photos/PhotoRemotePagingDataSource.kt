package com.aungmyolwin.splasher.data.photos

import androidx.paging.PageKeyedDataSource
import com.aungmyolwin.splasher.BuildConfig
import com.aungmyolwin.splasher.api.ApiService
import com.aungmyolwin.splasher.vo.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * a touch of amlwin on 01/06/2020.
 * made with <3
 */

class PhotoRemotePagingDataSource(private val api: ApiService) : PageKeyedDataSource<Int, Photo>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Photo>) {
        Timber.d("load initial requestedLoadSize:${params.requestedLoadSize}")
        //todo it's more better access key is inject with AssistInject
        api.getPhoto(BuildConfig.ACCESS_KEY, params.requestedLoadSize, 0)
                .enqueue(object : Callback<List<Photo>> {
                    override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                        t.printStackTrace()
                    }

                    override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                        if (response.isSuccessful) {
                            callback.onResult(response.body()?.toMutableList()
                                    ?: emptyList(), null, 3)
                        }
                    }

                })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        Timber.d("load initial requestedLoadSize:${params.requestedLoadSize} key:${params.key}")
        //todo it's more better access key is inject with AssistInject
        api.getPhoto(BuildConfig.ACCESS_KEY, params.requestedLoadSize, params.key)
                .enqueue(object : Callback<List<Photo>> {
                    override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                        t.printStackTrace()
                    }

                    override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                        if (response.isSuccessful) {
                            callback.onResult(response.body()?.toMutableList()
                                    ?: emptyList(), params.key + 1)
                        }
                    }

                })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        TODO("Not yet implemented")
    }

}