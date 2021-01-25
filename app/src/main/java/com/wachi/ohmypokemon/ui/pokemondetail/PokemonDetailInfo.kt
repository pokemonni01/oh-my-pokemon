package com.wachi.ohmypokemon.ui.pokemondetail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonDetailInfo(
    val pokemonId: String?
): Parcelable