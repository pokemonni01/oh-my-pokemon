package com.wachi.ohmypokemon.core

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.wachi.ohmypokemon.core.dialog.Dialog
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

open class BaseActivity : AppCompatActivity() {

    protected val dialog: Dialog by inject { parametersOf(this) }

    fun openExternalBrowser(url: String) {
        try {
            var correctUrl = url
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                correctUrl = "http://$url"
            }
            val intent = Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse(correctUrl))
            intent.resolveActivity(packageManager)?.let {
                startActivity(intent)
            }
        } catch (e: Exception) {
            // Ignore
        }
    }
}