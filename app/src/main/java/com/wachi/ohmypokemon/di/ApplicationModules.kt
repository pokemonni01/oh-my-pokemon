package com.wachi.ohmypokemon.di

import android.app.Activity
import com.wachi.ohmypokemon.core.dialog.Dialog
import com.wachi.ohmypokemon.core.dialog.DialogImpl
import org.koin.dsl.module

val coreModule = module {
    factory<Dialog> { (activity: Activity) -> DialogImpl(activity) }
}