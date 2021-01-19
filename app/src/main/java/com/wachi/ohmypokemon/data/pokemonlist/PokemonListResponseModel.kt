package com.wachi.ohmypokemon.data.pokemonlist

import com.google.gson.annotations.SerializedName
import com.wachi.ohmypokemon.domain.pokemonlist.Pokemon
import com.wachi.ohmypokemon.domain.pokemonlist.PokemonList

data class PokemonListResponseModel(
    @SerializedName("count") val count: Long,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: List<Result>
)

data class Result(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
)

fun PokemonListResponseModel.mapToDomain(): PokemonList {
    return PokemonList(
        pokemon = this.results.map {
            Pokemon(
                id = "1",
                name = it.name,
                image = ""
            )
        }
    )
}
