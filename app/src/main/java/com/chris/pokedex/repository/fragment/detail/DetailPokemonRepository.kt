package com.chris.pokedex.repository.fragment.detail

import com.chris.pokedex.model.PokemonBasicModel
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import kotlinx.coroutines.flow.Flow

interface DetailPokemonRepository {
    fun getDetailPokemon(pokemonBasicModel: PokemonBasicModel): Flow<UIStateDetailPokemon>
}