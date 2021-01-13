package com.wachi.ohmypokemon.data

import com.wachi.ohmypokemon.BuildConfig

interface ConfigRepository {

    fun getBaseUrl(): String

    fun getRssFeedUrl(): String
}

class ConfigRepositoryImpl: ConfigRepository {
    override fun getBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    override fun getRssFeedUrl(): String {
        return BuildConfig.POKEMON_RSS_NEWS_URL
    }

}