package com.wachi.ohmypokemon.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    private val _loading by lazy { MutableLiveData<Boolean>() }
    val loading: LiveData<Boolean> by lazy { _loading }

    protected fun showLoading() {
        _loading.value = true
    }

    protected fun hideLoading() {
        _loading.value = false
    }
}