package com.wachi.ohmypokemon.ui.pokemonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wachi.ohmypokemon.R
import com.wachi.ohmypokemon.core.BaseFragment

class PokemonListFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = PokemonListFragment()
    }
}