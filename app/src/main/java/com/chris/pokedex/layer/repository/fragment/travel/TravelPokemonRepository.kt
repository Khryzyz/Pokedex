package com.chris.pokedex.layer.repository.fragment.travel

import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import kotlinx.coroutines.flow.Flow

interface TravelPokemonRepository {
    suspend fun getDetailPokemon(listPokemonId: List<Int>): Flow<UIStateDetailPokemon>
    suspend fun insertCaughtPokemon(pokemonModel: PokemonModel, action: Constants.TravelAction)
}