package com.aungmyolwin.splasher.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import androidx.annotation.NonNull
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aungmyolwin.splasher.list.PhotoListViewModels
import com.aungmyolwin.splasher.repository.PhotoRepository


/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class SplasherViewModelFactory(private val repository: PhotoRepository) : ViewModelProvider.Factory {
    private val application: Application? = null

    @SuppressLint("StaticFieldLeak")
    @Volatile
    private var INSTANCE: SplasherViewModelFactory? = null


    fun getInstance(repository: PhotoRepository): SplasherViewModelFactory? {

        if (INSTANCE == null) {
            synchronized(SplasherViewModelFactory::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = SplasherViewModelFactory(repository)
                }
            }
        }
        return INSTANCE
    }

    @VisibleForTesting
    fun destroyInstance() {
        INSTANCE = null
    }


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoListViewModels::class.java!!)) {
            return PhotoListViewModels(repository) as T

        } /*else if (modelClass.isAssignableFrom(BookshelfViewModel::class.java!!)) {
            return BookshelfViewModel(repository) as T

        }*/
        throw IllegalArgumentException("Unknown ViewModel class" + modelClass.name)
    }

}