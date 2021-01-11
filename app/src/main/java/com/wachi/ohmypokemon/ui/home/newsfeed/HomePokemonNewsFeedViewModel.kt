package com.wachi.ohmypokemon.ui.home.newsfeed

import androidx.lifecycle.viewModelScope
import com.prof.rssparser.Parser
import com.wachi.ohmypokemon.core.BaseViewModel
import kotlinx.coroutines.launch
import java.nio.charset.Charset

class HomePokemonNewsFeedViewModel: BaseViewModel() {

    private val parser = Parser.Builder()
        .charset(Charset.forName("ISO-8859-7"))
        .build()

    fun getNewsFeed() {
        viewModelScope.launch {
            try {
                val channel = parser.getChannel("https://www.pokemon.com/us/pokemon-news/rss")
                // Do something with your data
                print(channel)
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle the exception
            }
        }
    }
}