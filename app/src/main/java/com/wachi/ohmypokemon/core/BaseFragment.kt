package com.wachi.ohmypokemon.core

import androidx.fragment.app.Fragment
import com.wachi.ohmypokemon.core.dialog.Dialog
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

open class BaseFragment: Fragment() {

    protected val dialog: Dialog by inject { parametersOf(requireActivity()) }

    protected fun <V : BaseViewModel> V.observeLoading() =
        apply {
            loading.observe(this@BaseFragment, {
                dialog.loading(it)
            })
        }
}