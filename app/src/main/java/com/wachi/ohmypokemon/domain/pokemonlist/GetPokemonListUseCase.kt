package com.wachi.ohmypokemon.domain.pokemonlist

import com.wachi.ohmypokemon.core.UseCase
import com.wachi.ohmypokemon.data.pokemon.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonListUseCase(
    private val pokemonRepository: PokemonRepository
): UseCase<PokemonListBody, PokemonList>() {

    override fun validateRequest(request: PokemonListBody): PokemonListBody {
        return request
    }

    override suspend fun executeRepo(
        request: PokemonListBody
    ): Flow<PokemonList> {
        return pokemonRepository.getPokemonList(request)
    }
}