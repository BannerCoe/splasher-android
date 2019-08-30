package com.aungmyolwin.splasher.list

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

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class PhotoListViewModels(loadAllPhotoUseCase: LoadAllPhotoUseCase) : ViewModel() {

    private val vmJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + vmJob)

    private val _photos = MutableLiveData<Result<List<Photo>>>()
    val photos: LiveData<Result<List<Photo>>> get() = _photos

    init {
        uiScope.launch {
            _photos.value = Result.Loading
            _photos.value = loadAllPhotoUseCase.execute()
        }

    }

    override fun onCleared() {
        vmJob.cancel();
    }
}