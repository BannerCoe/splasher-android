package com.aungmyolwin.splasher.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aungmyolwin.splasher.domain.photos.LoadAllPhotoUseCase
import com.aungmyolwin.splasher.utils.Event
import com.aungmyolwin.splasher.vo.Photo
import com.aungmyolwin.splasher.vo.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class PhotoListViewModels @Inject constructor(loadAllPhotoUseCase: LoadAllPhotoUseCase) : ViewModel() {

    lateinit var loading: LiveData<Boolean>
    lateinit var photos: LiveData<List<Photo>?>
    lateinit var errorMessage: LiveData<Event<String>>

    init {
        viewModelScope.launch {
            val result = loadAllPhotoUseCase.execute()

            loading = Transformations.map(result) {
                (it is Result.Loading)
            }

            photos = Transformations.map(result) {
                (it as? Result.Success)?.data
            }

            errorMessage = Transformations.map(result) {
                Event(content = (it as? Result.Error)?.exception?.localizedMessage ?: "")
            }
        }
    }

}