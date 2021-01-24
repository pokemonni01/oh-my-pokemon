package com.wachi.ohmypokemon.data

import com.wachi.ohmypokemon.BuildConfig

interface ConfigRepository {

    fun getBaseUrl(): String

    fun getRssFeedUrl(): String

    fun getPokemonImageUrl(pokemonId: String): String
}

class ConfigRepositoryImpl: ConfigRepository {
    override fun getBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    override fun getRssFeedUrl(): String {
        return BuildConfig.POKEMON_RSS_NEWS_URL
    }

    override fun getPokemonImageUrl(pokemonId: String): String {
        return BuildConfig.POKEMON_IMAGE_URL.plus("$pokemonId.png")
    }
}