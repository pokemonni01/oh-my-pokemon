package com.wachi.ohmypokemon.ui.home

import android.os.Bundle
import com.wachi.ohmypokemon.R
import com.wachi.ohmypokemon.core.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewPagerHome.adapter = HomeViewPagerAdapter(this)
        btnFeed.setOnClickListener { viewPagerHome.currentItem = POKEMON_NEWS_FEED_PAGE_INDEX }
        btnPokemonList.setOnClickListener { viewPagerHome.currentItem = POKEMON_LIST_PAGE_INDEX }
    }
}