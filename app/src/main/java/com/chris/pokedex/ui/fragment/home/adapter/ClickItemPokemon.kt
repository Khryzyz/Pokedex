package com.chris.pokedex.ui.fragment.home.adapter

import com.chris.pokedex.model.PokemonBasicModel

interface ClickItemPokemon {
    fun onClickNavigateDetail(pokemonBasicModel: PokemonBasicModel)
}