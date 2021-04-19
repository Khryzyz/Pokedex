package com.chris.pokedex.layer.ui.repository

import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.UIState
import kotlinx.coroutines.flow.Flow

interface ListPokemonRepository {
    suspend fun getListPokemonByGeneration(generation: Constants.Generation): Flow<UIState>
}