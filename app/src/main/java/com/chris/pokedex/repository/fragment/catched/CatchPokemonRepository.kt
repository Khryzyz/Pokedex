package com.chris.pokedex.repository.fragment.catched

import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow

interface CatchPokemonRepository {
    fun getListPokemon(): Flow<UIStateListPokemon>
}