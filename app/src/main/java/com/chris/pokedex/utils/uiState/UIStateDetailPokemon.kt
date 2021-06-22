package com.chris.pokedex.utils.uiState

import com.chris.pokedex.model.PokemonModel

sealed class UIStateDetailPokemon {

    object Loading : UIStateDetailPokemon()
    class Progress(
        val progress: Int,
        val total: Int,
        val pokemonModel: PokemonModel
    ) : UIStateDetailPokemon()

    class Success(val data: PokemonModel) : UIStateDetailPokemon()
    class Error(val errorMessage: String) : UIStateDetailPokemon()

}