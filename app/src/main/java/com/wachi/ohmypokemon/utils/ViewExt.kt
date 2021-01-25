package com.wachi.ohmypokemon.utils

import android.os.Build
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

fun View.visible() { this.visibility = View.VISIBLE }
fun View.gone() { this.visibility = View.GONE }

fun <T : TextView> T.setTextViewInHtml(text: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT))
    } else {
        setText(Html.fromHtml(text))
    }
}

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}