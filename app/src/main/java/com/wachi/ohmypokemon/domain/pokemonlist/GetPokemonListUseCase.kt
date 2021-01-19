package com.wachi.ohmypokemon.domain.pokemonlist

import com.wachi.ohmypokemon.core.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPokemonListUseCase: UseCase<PokemonListBody, PokemonList>() {

    override fun validateRequest(request: PokemonListBody): PokemonListBody {
        return request
    }

    override suspend fun executeRepo(
        request: PokemonListBody
    ): Flow<PokemonList> {
        return flow {
            emit(PokemonList(
                pokemon = listOf(
                    Pokemon("1", "Test 1", ""),
                    Pokemon("2", "Test 2", ""),
                )
            ))
        }
    }
}