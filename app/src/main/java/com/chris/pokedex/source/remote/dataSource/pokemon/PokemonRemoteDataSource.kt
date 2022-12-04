package com.chris.pokedex.source.remote.dataSource.pokemon

import com.chris.pokedex.model.PokemonBasicModel
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {
    fun getListPokemon(generation: Constants.Generation): Flow<UIStateListPokemon>
    fun getDetailPokemon(pokemonBasicModel: PokemonBasicModel): Flow<UIStateDetailPokemon>
    fun getDetailPokemon(listPokemonId: List<Int>): Flow<UIStateDetailPokemon>
}