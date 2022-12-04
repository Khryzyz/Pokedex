package com.chris.pokedex.repository.fragment.travel

import com.chris.pokedex.model.PokemonModel
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import kotlinx.coroutines.flow.Flow

interface TravelPokemonRepository {
    fun getDetailPokemon(listPokemonId: List<Int>): Flow<UIStateDetailPokemon>
    suspend fun insertCaughtPokemon(pokemonModel: PokemonModel, action: Constants.TravelAction)
}