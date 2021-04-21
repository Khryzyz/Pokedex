package com.chris.pokedex.utils

sealed class UIState {

    class Success(val data: Any) : UIState()
    class Progress(val progress: Int, val total: Int) : UIState()
    object Load : UIState()
    class Error(val message: String) : UIState()

}