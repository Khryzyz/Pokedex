package com.chris.pokedex.utils

sealed class UIState {

    class Success(val data: Any) : UIState()
    object Load : UIState()
    class Error(val message: String) : UIState()

}