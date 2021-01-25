package com.wachi.ohmypokemon.data.pokemon

import com.wachi.ohmypokemon.core.BaseService
import com.wachi.ohmypokemon.data.ConfigRepository
import com.wachi.ohmypokemon.data.pokemon.detail.PokemonDetailResponseModel
import com.wachi.ohmypokemon.data.pokemon.detail.mapToDomain
import com.wachi.ohmypokemon.data.pokemon.list.PokemonListResponseModel
import com.wachi.ohmypokemon.domain.pokemondetail.PokemonDetail
import com.wachi.ohmypokemon.domain.pokemonlist.Pokemon
import com.wachi.ohmypokemon.domain.pokemonlist.PokemonList
import com.wachi.ohmypokemon.domain.pokemonlist.PokemonListBody
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getPokemonList(pokemonListBody: PokemonListBody): Flow<PokemonList>

    suspend fun getPokemonDetail(id: String): Flow<PokemonDetail>

}

class PokemonRepositoryImpl(
    private val pokemonService: PokemonService,
    private val configRepository: ConfigRepository
) : PokemonRepository {

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

    private fun PokemonListResponseModel.mapToDomain(): PokemonList {
        val pattern = "\\/([0-9]+)\\/"
        val regex = Regex(pattern)
        return PokemonList(
            pokemon = this.results.map {
                val pokemonId = regex.find(it.url)?.groups?.get(1)?.value ?: ""
                Pokemon(
                    id = pokemonId,
                    name = it.name.capitalize(),
                    image = configRepository.getPokemonImageUrl(pokemonId)
                )
            }
        )
    }

    override suspend fun getPokemonDetail(id: String): Flow<PokemonDetail> {
        return object : BaseService<PokemonDetailResponseModel, PokemonDetail>() {
            override suspend fun callApi(): PokemonDetailResponseModel {
                return pokemonService.getPokemonDetail(id)
            }

            override fun mapper(from: PokemonDetailResponseModel): PokemonDetail {
                return from.mapToDomain(configRepository.getPokemonImageUrl(id))
            }

        }.execute()
    }
}