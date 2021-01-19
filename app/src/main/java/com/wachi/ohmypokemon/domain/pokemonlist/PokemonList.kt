package com.wachi.ohmypokemon.domain.pokemonlist

data class PokemonList(
    val pokemon: List<Pokemon?>?
)

data class Pokemon(
    val id: String?,
    val name: String?,
    val image: String?
)