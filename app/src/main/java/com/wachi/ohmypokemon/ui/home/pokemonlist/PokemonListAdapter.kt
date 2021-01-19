package com.wachi.ohmypokemon.ui.home.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wachi.ohmypokemon.R
import com.wachi.ohmypokemon.domain.pokemonlist.Pokemon
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonListAdapter(
    private val pokemonList: ArrayList<Pokemon?>,
    private val onItemSelect: (Pokemon) -> Unit
) : RecyclerView.Adapter<PokemonListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_pokemon,
            parent, false
        )
        return PokemonListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        val item = pokemonList[position]
        holder.setViewData(item)
    }

    override fun getItemCount() = pokemonList.size

    fun onUpdateItem(list: ArrayList<Pokemon?>) {
        pokemonList.clear()
        pokemonList.addAll(list)
        notifyDataSetChanged()
    }
}

class PokemonListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun setViewData(item: Pokemon?) {
        Glide.with(view)
            .load(item?.image ?: "")
            .into(view.ivPokemonImage)
        view.tvPokemonName.text = item?.name ?: ""
    }
}