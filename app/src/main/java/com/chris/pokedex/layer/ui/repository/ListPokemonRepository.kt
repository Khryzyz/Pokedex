package com.chris.pokedex.layer.ui.repository

import com.chris.pokedex.utils.Constants

interface ListPokemonRepository {
    fun getListPokemonByGeneration(generation: Constants.Generation)
}