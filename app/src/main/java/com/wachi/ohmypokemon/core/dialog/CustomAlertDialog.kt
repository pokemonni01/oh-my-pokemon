package com.wachi.ohmypokemon.core.dialog

import android.content.Context
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import com.wachi.ohmypokemon.R
import com.wachi.ohmypokemon.utils.gone
import kotlinx.android.synthetic.main.custom_alert_dialog.*

class CustomAlertDialog(
    context: Context
) : AppCompatDialog(context) {

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.custom_alert_dialog)
        setCancelable(false)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window?.setBackgroundDrawableResource(android.R.color.transparent)
    }

    fun setTitle(text: String) {
        tvTitle?.text = text
    }

    fun setMessage(text: String) {
        tvMessage?.text = text
    }

    fun setNegativeButtonText(text: String) {
        btnNegative?.text = text
    }

    fun setOnClickNegativeButton(onClick: () -> Unit) {
        btnNegative?.setOnClickListener { onClick() }
    }

    fun setPositiveButtonText(text: String) {
        btnPositive?.text = text
    }

    fun setOnClickPositiveButton(onClick: () -> Unit) {
        btnPositive?.setOnClickListener { onClick() }
    }

    fun hideNegativeButton() {
        btnNegative?.gone()
    }
}