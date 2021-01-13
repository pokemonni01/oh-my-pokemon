package com.wachi.ohmypokemon.domain.rssfeed

data class RSSFeedModel(
    val imageUrl: String?,
    val pubDate: String?,
    val author: String?,
    val title: String?,
    val content: String?,
    val description: String?
)