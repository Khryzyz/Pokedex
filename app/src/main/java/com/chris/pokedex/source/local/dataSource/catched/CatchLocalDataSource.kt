package com.chris.pokedex.source.local.dataSource.catched

import com.chris.pokedex.model.PokemonModel
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow

interface CatchLocalDataSource {
    suspend fun insertCaughtPokemon(pokemonModel: PokemonModel, action: Constants.TravelAction)
    fun getListPokemon(): Flow<UIStateListPokemon>
}