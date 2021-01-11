package com.wachi.ohmypokemon.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wachi.ohmypokemon.ui.home.newsfeed.HomePokemonNewsFeedFragment
import com.wachi.ohmypokemon.ui.home.pokemonlist.PokemonListFragment

const val POKEMON_NEWS_FEED_PAGE_INDEX = 0
const val POKEMON_LIST_PAGE_INDEX = 1

private const val PAGE_COUNT = 2

class HomeViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {

    override fun getItemCount() = PAGE_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            POKEMON_NEWS_FEED_PAGE_INDEX -> HomePokemonNewsFeedFragment.newInstance()
            POKEMON_LIST_PAGE_INDEX -> PokemonListFragment.newInstance()
            else -> Fragment()
        }
    }
}