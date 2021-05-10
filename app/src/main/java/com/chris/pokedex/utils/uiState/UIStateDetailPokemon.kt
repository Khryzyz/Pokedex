package com.chris.pokedex.utils.uiState

import com.chris.pokedex.layer.model.PokemonModel

sealed class UIStateDetailPokemon {

    object Loading : UIStateDetailPokemon()
    class Success(val data: PokemonModel) : UIStateDetailPokemon()
    class Error(val errorMessage: String) : UIStateDetailPokemon()

}