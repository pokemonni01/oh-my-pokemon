package com.wachi.ohmypokemon.ui.home.newsfeed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wachi.ohmypokemon.R
import com.wachi.ohmypokemon.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_home_pokemon_news_feed.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomePokemonNewsFeedFragment : BaseFragment() {

    private val viewModel: HomePokemonNewsFeedViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_pokemon_news_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNewsFeed()
        btnGetNewsFeed.setOnClickListener { viewModel.getNewsFeed() }
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomePokemonNewsFeedFragment()
    }
}