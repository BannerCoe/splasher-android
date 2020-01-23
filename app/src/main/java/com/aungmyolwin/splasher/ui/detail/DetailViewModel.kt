package com.aungmyolwin.splasher.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.aungmyolwin.splasher.vo.Photo

/**
 * a touch of amlwin on 2020-01-09.
 * made with <3
 */

class DetailViewModel : ViewModel() {

    private val photo = MutableLiveData<Photo>()

    val photoUrl = Transformations.map(photo) {
        it.urls.regular
    }

    fun loadPhoto(photo: Photo) {
        this.photo.value = photo
    }
}