package com.wachi.ohmypokemon.core.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.Window
import com.wachi.ohmypokemon.R

class LoadingView(
    private val context: Context,
    dismissListener: DialogInterface.OnDismissListener? = null
) {

    private val loadingDialog: Dialog by lazy {
        Dialog(context)
            .apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setContentView(R.layout.loading_view)
                window?.setBackgroundDrawableResource(android.R.color.transparent)
                setCancelable(false)
                setOnDismissListener(dismissListener)
            }
    }

    fun isLoading(): Boolean = loadingDialog.isShowing

    private fun isFinishing(): Boolean {
        return (context as? Activity)?.isFinishing ?: true
    }

    fun show() {
        if (!loadingDialog.isShowing && !isFinishing()) {
            loadingDialog.show()
        }
    }

    fun dismiss() {
        if (loadingDialog.isShowing) {
            loadingDialog.dismiss()
        }
    }
}
