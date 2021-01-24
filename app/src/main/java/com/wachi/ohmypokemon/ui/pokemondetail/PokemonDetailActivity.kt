package com.wachi.ohmypokemon.ui.pokemondetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.wachi.ohmypokemon.R
import com.wachi.ohmypokemon.core.BaseActivity
import com.wachi.ohmypokemon.domain.pokemondetail.PokemonDetail

class PokemonDetailActivity : BaseActivity() {

    private val pokemonDetailInfo: PokemonDetailInfo? by lazy {
        intent.getParcelableExtra(POKEMON_DETAIL_INFO)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentPokemonDetail) as NavHostFragment
        val navController = navHostFragment.navController
        val bundle = Bundle()
        bundle.putString(POKEMON_ID, pokemonDetailInfo?.pokemonId ?: "")
        navController.setGraph(R.navigation.nav_pokemon_detail, bundle)
    }

    companion object {

        fun newInstance(context: Context, pokemonDetailInfo: PokemonDetailInfo) {
            val intent = Intent(context, PokemonDetailActivity::class.java)
            intent.putExtra(POKEMON_DETAIL_INFO, pokemonDetailInfo)
            context.startActivity(intent)
        }

        private const val POKEMON_ID = "POKEMON_ID"
        private const val POKEMON_DETAIL_INFO = "GOLD_BUY_INFO"
    }
}