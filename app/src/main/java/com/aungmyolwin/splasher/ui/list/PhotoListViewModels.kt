package com.aungmyolwin.splasher.ui.list

import androidx.lifecycle.*
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

    var rawResponse = MediatorLiveData<Result<List<Photo>>>()

    val photos: LiveData<List<Photo>> = Transformations.map(rawResponse) {
        (it as? Result.Success)?.data
    }

    val loading: LiveData<Boolean> = Transformations.map(rawResponse) {
        (it is Result.Loading)
    }

    val errorMessage: LiveData<Event<String>> = Transformations.map(rawResponse) {
        Event(content = (it as? Result.Error)?.exception?.localizedMessage ?: "")
    }

    init {
        viewModelScope.launch {
            rawResponse.addSource(loadAllPhotoUseCase.execute()) {
                rawResponse.value = it
            }
        }
    }

}