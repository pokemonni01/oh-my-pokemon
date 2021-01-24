package com.wachi.ohmypokemon.ui.home.pokemonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wachi.ohmypokemon.R
import com.wachi.ohmypokemon.core.BaseFragment
import com.wachi.ohmypokemon.ui.pokemondetail.PokemonDetailActivity
import com.wachi.ohmypokemon.ui.pokemondetail.PokemonDetailInfo
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
class PokemonListFragment : BaseFragment() {

    private val viewModel: PokemonListViewModel by viewModel()

    private val recyclerViewAdapter: PokemonListAdapter =
        PokemonListAdapter(arrayListOf()) { pokemon ->
            activity?.let {
                PokemonDetailActivity.newInstance(it, PokemonDetailInfo(pokemon.id))
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observe()
        viewModel.getPokemonList()
    }

    private fun observe() {
        viewModel.observeLoading()
        viewModel.pokemonList.observe(viewLifecycleOwner, {
            recyclerViewAdapter.onUpdateItem(ArrayList(it))
        })
    }

    private fun setupRecyclerView() {
        recyclerViewPokemon.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = recyclerViewAdapter
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = PokemonListFragment()
    }
}