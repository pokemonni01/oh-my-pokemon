package com.wachi.ohmypokemon.data.pokemon.list

import com.google.gson.annotations.SerializedName

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
