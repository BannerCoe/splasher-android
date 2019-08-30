package com.aungmyolwin.splasher.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class SplasherViewModelFactory @Inject constructor(private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val found = creators.entries.find { modelClass.isAssignableFrom(it.key) }
        val creator = found?.value
                ?: throw IllegalArgumentException("unknown model class $modelClass")
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}