package com.chris.pokedex.layer.repository.list

import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow

interface ListPokemonRepository {

    suspend fun getListPokemon(generation: Constants.Generation): Flow<UIStateListPokemon>

}