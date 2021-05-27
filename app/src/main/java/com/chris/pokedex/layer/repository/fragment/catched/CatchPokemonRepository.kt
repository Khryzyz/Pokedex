package com.chris.pokedex.layer.repository.fragment.catched

import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow

interface CatchPokemonRepository {
    suspend fun getListPokemon(): Flow<UIStateListPokemon>
}