package com.chris.pokedex.utils.uiState

import com.chris.pokedex.layer.model.PokemonBasicModel

sealed class UIStateListPokemonLocal {

    class Success(val listPokemonModel: List<PokemonBasicModel>) : UIStateListPokemonLocal()
    class Progress(val progress: Int, val total: Int) : UIStateListPokemonLocal()
    object Load : UIStateListPokemonLocal()
    class Error(val errorMessage: String) : UIStateListPokemonLocal()

}