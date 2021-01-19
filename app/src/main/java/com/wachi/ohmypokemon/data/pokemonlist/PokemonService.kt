package com.wachi.ohmypokemon.data.pokemonlist

import retrofit2.http.GET

interface PokemonService {

    @GET("pokemon/")
    suspend fun getPokemonList(): PokemonListResponseModel
}