package com.wachi.ohmypokemon.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow

abstract class UseCase<REQUEST, RESPONSE> {
    abstract fun validateRequest(request: REQUEST): REQUEST

    protected abstract suspend fun executeRepo(request: REQUEST, isRetry: Boolean): Flow<RESPONSE>

    fun execute(request: REQUEST, isRetry: Boolean = true): Flow<RESPONSE> =
        flow { emit(validateRequest(request)) }
            .flatMapConcat { executeRepo(it, isRetry) }
}