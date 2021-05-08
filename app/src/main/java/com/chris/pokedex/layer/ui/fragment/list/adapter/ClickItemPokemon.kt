package com.chris.pokedex.layer.ui.fragment.list.adapter

import com.chris.pokedex.layer.model.PokemonBasicModel

interface ClickItemPokemon {
    fun onClickNavigateDetail(pokemonBasicModel: PokemonBasicModel)
}