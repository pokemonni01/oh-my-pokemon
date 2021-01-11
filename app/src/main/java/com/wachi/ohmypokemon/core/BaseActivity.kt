package com.wachi.ohmypokemon.core

import androidx.appcompat.app.AppCompatActivity
import com.wachi.ohmypokemon.core.dialog.Dialog
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

open class BaseActivity : AppCompatActivity() {

    protected val dialog: Dialog by inject { parametersOf(this) }
}