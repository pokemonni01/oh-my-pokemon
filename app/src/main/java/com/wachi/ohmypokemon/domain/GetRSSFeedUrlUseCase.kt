package com.wachi.ohmypokemon.domain

import com.wachi.ohmypokemon.core.UseCase
import com.wachi.ohmypokemon.data.ConfigRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRSSFeedUrlUseCase(
    private val configRepository: ConfigRepository
): UseCase<Unit, String>() {

    override fun validateRequest(request: Unit) {
        return request
    }

    override suspend fun executeRepo(request: Unit, isRetry: Boolean): Flow<String> {
        return flow { emit(configRepository.getRssFeedUrl()) }
    }
}