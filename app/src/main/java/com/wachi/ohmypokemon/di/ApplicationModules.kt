package com.wachi.ohmypokemon.di

import android.app.Activity
import com.google.gson.GsonBuilder
import com.prof.rssparser.Parser
import com.readystatesoftware.chuck.ChuckInterceptor
import com.wachi.ohmypokemon.BuildConfig
import com.wachi.ohmypokemon.core.dialog.Dialog
import com.wachi.ohmypokemon.core.dialog.DialogImpl
import com.wachi.ohmypokemon.data.ConfigRepository
import com.wachi.ohmypokemon.data.ConfigRepositoryImpl
import com.wachi.ohmypokemon.data.pokemon.PokemonRepository
import com.wachi.ohmypokemon.data.pokemon.PokemonRepositoryImpl
import com.wachi.ohmypokemon.data.pokemon.PokemonService
import com.wachi.ohmypokemon.data.rssfeed.RSSFeedRepository
import com.wachi.ohmypokemon.data.rssfeed.RSSFeedRepositoryImpl
import com.wachi.ohmypokemon.domain.pokemondetail.GetPokemonDetailUseCase
import com.wachi.ohmypokemon.domain.pokemonlist.GetPokemonListUseCase
import com.wachi.ohmypokemon.domain.rssfeed.GetRSSFeedUseCase
import com.wachi.ohmypokemon.ui.home.newsfeed.HomePokemonNewsFeedViewModel
import com.wachi.ohmypokemon.ui.home.pokemonlist.PokemonListViewModel
import com.wachi.ohmypokemon.ui.pokemondetail.detail.PokemonDetailViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

private const val CHARSET_NAME = "ISO-8859-7"

val coreModule = module {
    single {
        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .apply {
                val bodyLogging = HttpLoggingInterceptor()
                bodyLogging.level = HttpLoggingInterceptor.Level.BODY
                if (BuildConfig.DEBUG) {
                    this.addNetworkInterceptor(bodyLogging)
                    this.addInterceptor(ChuckInterceptor(androidContext()))
                }

            }
        client.build()
    }
    single {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        Retrofit.Builder()
            .client(get())
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    factory<Dialog> { (activity: Activity) -> DialogImpl(activity) }
    factory {
        Parser.Builder()
            .charset(Charset.forName(CHARSET_NAME))
            .build()
    }
}

val repositoryModule = module {
    single { get<Retrofit>().create(PokemonService::class.java) }

    factory<ConfigRepository> { ConfigRepositoryImpl() }
    factory<RSSFeedRepository> { RSSFeedRepositoryImpl(get(), get()) }
    factory<PokemonRepository> { PokemonRepositoryImpl(get(), get()) }
}

val useCaseModule = module {
    factory { GetRSSFeedUseCase(get()) }
    factory { GetPokemonListUseCase(get()) }
    factory { GetPokemonDetailUseCase(get()) }
}

val homeModule = module {
    viewModel { HomePokemonNewsFeedViewModel(get()) }
    viewModel { PokemonListViewModel(get()) }
}

val pokemonDetailModule = module {
    viewModel { PokemonDetailViewModel(get()) }
}