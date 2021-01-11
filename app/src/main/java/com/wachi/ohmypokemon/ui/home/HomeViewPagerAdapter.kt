package com.wachi.ohmypokemon.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wachi.ohmypokemon.ui.pokemonlist.PokemonListFragment

private const val PAGE_COUNT = 1

private const val POKEMON_LIST_PAGE_INDEX = 0

class HomeViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {

    override fun getItemCount() = PAGE_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            POKEMON_LIST_PAGE_INDEX -> PokemonListFragment.newInstance()
            else -> Fragment()
        }
    }
}