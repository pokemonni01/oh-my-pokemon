package com.wachi.ohmypokemon.domain.pokemondetail

import com.wachi.ohmypokemon.core.UseCase
import com.wachi.ohmypokemon.data.pokemon.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonDetailUseCase(
    private val pokemonRepository: PokemonRepository
) : UseCase<String, PokemonDetail>() {

    override fun validateRequest(request: String): String {
        return request
    }

    override suspend fun executeRepo(
        request: String
    ): Flow<PokemonDetail> {
        return pokemonRepository.getPokemonDetail(request)
    }
}