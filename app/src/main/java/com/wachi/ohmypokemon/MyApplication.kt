package com.wachi.ohmypokemon

import android.app.Application
import com.wachi.ohmypokemon.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@MyApplication)
            val modules = arrayListOf(
                coreModule
            )
            modules(modules)
        }
    }
}