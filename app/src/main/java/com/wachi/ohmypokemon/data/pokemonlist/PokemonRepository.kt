package com.wachi.ohmypokemon.data.pokemonlist

import com.wachi.ohmypokemon.core.BaseService
import com.wachi.ohmypokemon.data.ConfigRepository
import com.wachi.ohmypokemon.domain.pokemonlist.PokemonList
import com.wachi.ohmypokemon.domain.pokemonlist.PokemonListBody
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun getPokemonList(pokemonListBody: PokemonListBody): Flow<PokemonList>
}

class PokemonRepositoryImpl(
    private val pokemonService: PokemonService,
    private val configRepository: ConfigRepository
): PokemonRepository {

    override suspend fun getPokemonList(pokemonListBody: PokemonListBody): Flow<PokemonList> {
        return object : BaseService<PokemonListResponseModel, PokemonList>() {
            override suspend fun callApi(): PokemonListResponseModel {
                return pokemonService.getPokemonList()
            }

            override fun mapper(from: PokemonListResponseModel): PokemonList {
                return from.mapToDomain()
            }

        }.execute()
    }
}