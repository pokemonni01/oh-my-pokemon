package com.wachi.ohmypokemon.ui.pokemondetail.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wachi.ohmypokemon.core.BaseViewModel
import com.wachi.ohmypokemon.domain.pokemondetail.GetPokemonDetailUseCase
import com.wachi.ohmypokemon.domain.pokemondetail.PokemonDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class PokemonDetailViewModel(
    private val pokemonDetailUseCase: GetPokemonDetailUseCase
) : BaseViewModel() {

    private val _pokemonDetail = MutableLiveData<PokemonDetail>()
    val pokemonDetail: LiveData<PokemonDetail> = _pokemonDetail

    fun getDetail(id: String?) {
        viewModelScope.launch {
            pokemonDetailUseCase.execute(id ?: "")
                .flowOn(Dispatchers.IO)
                .onStart { showLoading() }
                .onCompletion { hideLoading() }
                .collect { _pokemonDetail.value = it }
        }
    }
}