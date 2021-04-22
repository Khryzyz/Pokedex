package com.chris.pokedex.utils.uiState

import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.layer.model.PokemonModel

sealed class UIStateListPokemonLocal {

    class Success(val listPokemonModel: List<PokemonBasicModel>) : UIStateListPokemonLocal()
    class Progress(val progress: Int, val total: Int) : UIStateListPokemonLocal()
    object Load : UIStateListPokemonLocal()
    class Error(val message: String) : UIStateListPokemonLocal()

}