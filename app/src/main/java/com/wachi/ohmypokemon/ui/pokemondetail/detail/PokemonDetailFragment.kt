package com.wachi.ohmypokemon.ui.pokemondetail.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.wachi.ohmypokemon.R
import com.wachi.ohmypokemon.core.BaseFragment
import com.wachi.ohmypokemon.utils.loadImage
import kotlinx.android.synthetic.main.fragment_pokemon_detail.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
class PokemonDetailFragment : BaseFragment() {

    private val args: PokemonDetailFragmentArgs by navArgs()
    private val viewModel: PokemonDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        viewModel.getDetail(args.POKEMONID)
    }

    private fun observe() {
        viewModel.observeLoading()
        viewModel.pokemonDetail.observe(viewLifecycleOwner, {
            ivPokemonImage.loadImage(it.image ?: "")
        })
    }
}