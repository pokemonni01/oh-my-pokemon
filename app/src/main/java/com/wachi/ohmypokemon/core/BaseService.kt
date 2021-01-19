package com.wachi.ohmypokemon.core

import kotlinx.coroutines.flow.*

abstract class BaseService<RESPONSE, DOMAIN_MODEL> {

    abstract suspend fun callApi(): RESPONSE

    abstract fun mapper(from: RESPONSE): DOMAIN_MODEL

    fun execute(): Flow<DOMAIN_MODEL> =
        flow {
            emit(1)
        }.map {
            callApi()
        }.map { mapper(it) }
}