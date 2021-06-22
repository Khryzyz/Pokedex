package com.chris.pokedex.utils.uiState

import com.chris.pokedex.model.PokemonBasicModel

sealed class UIStateListPokemon {
    object Loading : UIStateListPokemon()
    class Success(val data: List<PokemonBasicModel>) : UIStateListPokemon()
    class Error(val errorMessage: String) : UIStateListPokemon()
}