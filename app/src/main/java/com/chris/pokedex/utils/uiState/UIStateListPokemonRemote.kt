package com.chris.pokedex.utils.uiState

import com.chris.pokedex.layer.model.PokemonBasicModel

sealed class UIStateListPokemonRemote {

    class Success(val data: List<PokemonBasicModel>) : UIStateListPokemonRemote()
    class Progress(val progress: Int, val total: Int) : UIStateListPokemonRemote()
    object Load : UIStateListPokemonRemote()
    class Error(val message: String) : UIStateListPokemonRemote()

}