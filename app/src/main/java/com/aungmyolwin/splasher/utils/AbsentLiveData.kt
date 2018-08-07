package com.aungmyolwin.splasher.utils

import androidx.lifecycle.LiveData

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class AbsentLiveData<T : Any?> private constructor() : LiveData<T>() {
    init {
        // use post instead of set since this can be created on any thread
        postValue(null)
    }

    companion object {
        fun <T> create(): LiveData<T> {
            return AbsentLiveData()
        }
    }
}