package com.wachi.ohmypokemon.ui.home.newsfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wachi.ohmypokemon.R
import com.wachi.ohmypokemon.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_home_pokemon_news_feed.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
class HomePokemonNewsFeedFragment : BaseFragment() {

    private val viewModel: HomePokemonNewsFeedViewModel by viewModel()

    private val recyclerViewAdapter: HomePokemonNewsFeedAdapter =
        HomePokemonNewsFeedAdapter(arrayListOf()) {
//            viewModel.handleItemClick(it)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_pokemon_news_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        setupRecyclerView()
        viewModel.getNewsFeed()
    }

    private fun observe() {
        viewModel.observeLoading()
        viewModel.rssFeedList.observe(viewLifecycleOwner, {
            recyclerViewAdapter.onUpdateItem(ArrayList(it))
        })
    }

    private fun setupRecyclerView() {
        recyclerViewRSSFeed.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = recyclerViewAdapter
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomePokemonNewsFeedFragment()
    }
}