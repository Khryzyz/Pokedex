package com.chris.pokedex.layer.repository.fragment.detail

import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import kotlinx.coroutines.flow.Flow

interface DetailPokemonRepository {

    suspend fun getDetailPokemon(pokemonBasicModel: PokemonBasicModel): Flow<UIStateDetailPokemon>

}