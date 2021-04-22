package com.chris.pokedex.layer.repository

import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIState
import com.chris.pokedex.utils.uiState.UIStateListPokemonLocal
import com.chris.pokedex.utils.uiState.UIStateListPokemonRemote
import kotlinx.coroutines.flow.Flow

interface ListPokemonRepository {
    suspend fun getListPokemonByGenerationFromRemote(generation: Constants.Generation): Flow<UIStateListPokemonRemote>
    suspend fun getCountPokemonByGeneration(generationId: Constants.Generation): Int
    suspend fun getListPokemonByGenerationFromLocal(generation: Constants.Generation): Flow<UIStateListPokemonLocal>
}