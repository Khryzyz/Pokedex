package com.chris.pokedex.utils.uiState

import com.chris.pokedex.layer.model.MoveModel

sealed class UIStateDetailMove {

    object Loading : UIStateDetailMove()
    class Success(val data: MoveModel) : UIStateDetailMove()
    class Error(val errorMessage: String) : UIStateDetailMove()

}