package com.wachi.ohmypokemon.core.dialog

import android.app.Activity
import androidx.annotation.StringRes
import com.wachi.ohmypokemon.R

interface Dialog {
    fun show(
        title: String,
        message: String,
        positiveButtonText: String,
        onClickPositiveButton: () -> Unit?,
    )

    fun show(
        title: String,
        message: String,
        positiveButtonText: String? = null,
        onClickPositiveButton: (() -> Unit)? = null,
        negativeButtonText: String? = null,
        onClickNegativeButton: (() -> Unit)? = null,
    )

    fun dismiss()
}

class DialogImpl(
    private val activity: Activity
): Dialog {

    private var dialog: CustomAlertDialog? = null

    override fun show(
        title: String,
        message: String,
        positiveButtonText: String,
        onClickPositiveButton: () -> Unit?
    ) {
        dialog = CustomAlertDialog(activity).apply {
            setTitle(title)
            setMessage(message)
            setPositiveButtonText(positiveButtonText)
        }
    }

    override fun show(
        title: String,
        message: String,
        positiveButtonText: String?,
        onClickPositiveButton: (() -> Unit)?,
        negativeButtonText: String?,
        onClickNegativeButton: (() -> Unit)?
    ) {
        dialog = CustomAlertDialog(activity).apply {
            setTitle(title)
            setMessage(message)
            setPositiveButtonText(positiveButtonText ?: getString(R.string.dialog_ok))
            setOnClickPositiveButton { onClickPositiveButton?.invoke() ?: this.dismiss() }
            if (negativeButtonText?.isNotEmpty() == true) {
                setNegativeButtonText(negativeButtonText)
                setOnClickPositiveButton { onClickNegativeButton?.invoke() ?: this.dismiss() }
            } else {
                hideNegativeButton()
            }
        }
    }

    override fun dismiss() {
        dialog?.dismiss()
        dialog = null
    }

    private fun getString(@StringRes id: Int) = activity.getString(id)
}