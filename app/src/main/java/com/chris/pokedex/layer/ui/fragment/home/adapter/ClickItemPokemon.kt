package com.chris.pokedex.layer.ui.fragment.home.adapter

import com.chris.pokedex.layer.model.PokemonBasicModel

interface ClickItemPokemon {
    fun onClickNavigateDetail(pokemonBasicModel: PokemonBasicModel)
}