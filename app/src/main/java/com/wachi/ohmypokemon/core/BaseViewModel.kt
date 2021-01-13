package com.wachi.ohmypokemon.core

import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    protected fun showLoading() {}

    protected fun hideLoading() {}
}