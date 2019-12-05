package com.aungmyolwin.splasher.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aungmyolwin.splasher.domain.photos.LoadAllPhotoUseCase
import com.aungmyolwin.splasher.vo.Photo
import com.aungmyolwin.splasher.vo.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class PhotoListViewModels @Inject constructor(loadAllPhotoUseCase: LoadAllPhotoUseCase) : ViewModel() {

    private val vmJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + vmJob)

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> get() = _photos

    private val _loading = MutableLiveData<Boolean>(true)
    val loading: LiveData<Boolean> get() = _loading

    init {
        uiScope.launch {
            _loading.value = true
            val rawPhotos = loadAllPhotoUseCase.execute()
            when (rawPhotos) {
                is Result.Success -> {
                    _loading.value = false
                    _photos.value = rawPhotos.data
                }
                is Result.Loading -> {
                    _loading.value = true
                }
                else -> {
                    //do for error
                }

            }
        }

    }

    override fun onCleared() {
        vmJob.cancel()
    }
}