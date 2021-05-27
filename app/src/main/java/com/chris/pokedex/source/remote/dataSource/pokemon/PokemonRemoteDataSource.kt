package com.chris.pokedex.source.remote.dataSource.pokemon

import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {
    suspend fun getListPokemon(generation: Constants.Generation): Flow<UIStateListPokemon>
    suspend fun getDetailPokemon(pokemonBasicModel: PokemonBasicModel): Flow<UIStateDetailPokemon>
    suspend fun getDetailPokemon(listPokemonId: List<Int>): Flow<UIStateDetailPokemon>
}