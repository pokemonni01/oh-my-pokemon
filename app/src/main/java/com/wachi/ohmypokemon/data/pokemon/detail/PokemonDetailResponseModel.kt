package com.wachi.ohmypokemon.data.pokemon.detail

import com.google.gson.annotations.SerializedName
import com.wachi.ohmypokemon.domain.pokemondetail.PokemonDetail

data class PokemonDetailResponseModel(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("height") val height: String?,
    @SerializedName("weight") val weight: String?,
)

fun PokemonDetailResponseModel.mapToDomain(imageUrl: String) = PokemonDetail(
    id = id,
    image = imageUrl
)
