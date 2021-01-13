package com.wachi.ohmypokemon.data.rssfeed

import com.prof.rssparser.Parser
import com.wachi.ohmypokemon.data.ConfigRepository
import com.wachi.ohmypokemon.domain.rssfeed.RSSFeedModel

interface RSSFeedRepository {
    suspend fun getRSSFeed(): List<RSSFeedModel>
}

class RSSFeedRepositoryImpl(
    private val configRepository: ConfigRepository,
    private val parser: Parser
) : RSSFeedRepository {

    override suspend fun getRSSFeed(): List<RSSFeedModel> {
        return parser.getChannel(configRepository.getRssFeedUrl()).articles.sortedBy {
            it.pubDate ?: ""
        }.map { RSSFeedModel(
            imageUrl = it.image,
            pubDate = it.pubDate,
            author = it.author,
            content = it.content,
            title = it.title,
            description = it.description
        ) }
    }
}