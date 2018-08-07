package com.aungmyolwin.splasher.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.aungmyolwin.splasher.repository.PhotoRepository

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class PhotoListViewModels(repository: PhotoRepository) : ViewModel() {
    private val clientId = MutableLiveData<String>()

    val photos = Transformations.switchMap(clientId) {
        repository.loadPhoto(it)
    }

    fun setClient(appId: String) {
        clientId.value = appId
    }
}