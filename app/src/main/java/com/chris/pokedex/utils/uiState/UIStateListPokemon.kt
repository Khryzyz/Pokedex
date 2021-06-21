package com.chris.pokedex.utils.uiState

import com.chris.pokedex.layer.model.PokemonBasicModel

sealed class UIStateListPokemon {
    object Loading : UIStateListPokemon()
    class Success(val data: List<PokemonBasicModel>) : UIStateListPokemon()
    class Error(val errorMessage: String) : UIStateListPokemon()
}