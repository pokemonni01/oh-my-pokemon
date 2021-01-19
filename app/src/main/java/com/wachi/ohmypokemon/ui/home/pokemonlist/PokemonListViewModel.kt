package com.wachi.ohmypokemon.ui.home.pokemonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wachi.ohmypokemon.core.BaseViewModel
import com.wachi.ohmypokemon.domain.pokemonlist.GetPokemonListUseCase
import com.wachi.ohmypokemon.domain.pokemonlist.Pokemon
import com.wachi.ohmypokemon.domain.pokemonlist.PokemonListBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class PokemonListViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase
): BaseViewModel() {

    private val _pokemonList = MutableLiveData<List<Pokemon?>>()
    val pokemonList: LiveData<List<Pokemon?>> = _pokemonList

    fun getPokemonList() {
        viewModelScope.launch {
            getPokemonListUseCase.execute(PokemonListBody())
                .flowOn(Dispatchers.IO)
                .onStart { showLoading() }
                .onCompletion { hideLoading() }
                .collect { _pokemonList.value = it.pokemon ?: listOf() }
        }
    }
}