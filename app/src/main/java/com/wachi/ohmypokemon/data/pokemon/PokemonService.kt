package com.wachi.ohmypokemon.data.pokemon

import com.wachi.ohmypokemon.data.pokemon.detail.PokemonDetailResponseModel
import com.wachi.ohmypokemon.data.pokemon.list.PokemonListResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/")
    suspend fun getPokemonList(): PokemonListResponseModel

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: String): PokemonDetailResponseModel
}