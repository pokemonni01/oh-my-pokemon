package com.wachi.ohmypokemon.di

import android.app.Activity
import com.prof.rssparser.Parser
import com.wachi.ohmypokemon.core.dialog.Dialog
import com.wachi.ohmypokemon.core.dialog.DialogImpl
import com.wachi.ohmypokemon.data.ConfigRepository
import com.wachi.ohmypokemon.data.ConfigRepositoryImpl
import com.wachi.ohmypokemon.data.rssfeed.RSSFeedRepository
import com.wachi.ohmypokemon.data.rssfeed.RSSFeedRepositoryImpl
import com.wachi.ohmypokemon.domain.GetRSSFeedUrlUseCase
import com.wachi.ohmypokemon.domain.rssfeed.GetRSSFeedUseCase
import com.wachi.ohmypokemon.ui.home.newsfeed.HomePokemonNewsFeedViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.nio.charset.Charset

private const val CHARSET_NAME = "ISO-8859-7"

val coreModule = module {
    factory<Dialog> { (activity: Activity) -> DialogImpl(activity) }
    factory {
        Parser.Builder()
            .charset(Charset.forName(CHARSET_NAME))
            .build()
    }
}

val repositoryModule = module {
    factory<ConfigRepository> { ConfigRepositoryImpl() }
    factory<RSSFeedRepository> { RSSFeedRepositoryImpl(get(), get()) }
}

val useCaseModule = module {
    factory { GetRSSFeedUrlUseCase(get()) }
    factory { GetRSSFeedUseCase(get()) }
}

val homeModule = module {
    viewModel { HomePokemonNewsFeedViewModel(get()) }
}