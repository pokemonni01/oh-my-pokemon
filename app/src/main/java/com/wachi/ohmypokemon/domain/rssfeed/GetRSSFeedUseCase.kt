package com.wachi.ohmypokemon.domain.rssfeed

import com.wachi.ohmypokemon.core.UseCase
import com.wachi.ohmypokemon.data.rssfeed.RSSFeedRepository
import com.wachi.ohmypokemon.domain.GetRSSFeedUrlUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRSSFeedUseCase(
    private val rssFeedRepository: RSSFeedRepository
): UseCase<Unit, List<RSSFeedModel>>() {

    override fun validateRequest(request: Unit) {
        return request
    }

    override suspend fun executeRepo(request: Unit, isRetry: Boolean): Flow<List<RSSFeedModel>> {
        return flow { emit(rssFeedRepository.getRSSFeed()) }
    }
}