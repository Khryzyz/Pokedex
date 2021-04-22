package com.chris.pokedex.utils.uiState

sealed class UIStateListPokemonRemote {

    class Success(val data: Any) : UIStateListPokemonRemote()
    class Progress(val progress: Int, val total: Int) : UIStateListPokemonRemote()
    object Load : UIStateListPokemonRemote()
    class Error(val message: String) : UIStateListPokemonRemote()

}