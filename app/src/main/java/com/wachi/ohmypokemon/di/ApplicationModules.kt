package com.wachi.ohmypokemon.di

import android.app.Activity
import com.wachi.ohmypokemon.core.dialog.Dialog
import com.wachi.ohmypokemon.core.dialog.DialogImpl
import com.wachi.ohmypokemon.ui.home.newsfeed.HomePokemonNewsFeedViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coreModule = module {
    factory<Dialog> { (activity: Activity) -> DialogImpl(activity) }
}

val homeModule = module {
    viewModel { HomePokemonNewsFeedViewModel() }
}