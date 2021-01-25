package com.wachi.ohmypokemon.core

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wachi.ohmypokemon.R
import com.wachi.ohmypokemon.core.dialog.Dialog
import com.wachi.ohmypokemon.utils.gone
import com.wachi.ohmypokemon.utils.visible
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

open class BaseActivity : AppCompatActivity() {

    protected val dialog: Dialog by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setUpToolbar()
    }

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

    fun showBackButton() {
        ivBack?.visible()
    }

    fun hideBackButton() {
        ivBack?.gone()
    }

    fun setTitle(text: String) {
        tvToolbarTitle.text = text
    }

    private fun setUpToolbar() {
        ivBack?.setOnClickListener {
            onBackPressed()
        }
    }
}