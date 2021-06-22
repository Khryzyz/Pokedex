package com.chris.pokedex.repository.fragment.catched

import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow

interface CatchPokemonRepository {
    suspend fun getListPokemon(): Flow<UIStateListPokemon>
}