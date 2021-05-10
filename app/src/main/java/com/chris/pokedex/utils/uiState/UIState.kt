package com.chris.pokedex.utils.uiState

sealed class UIState {
    class Success(val data: Any) : UIState()
    class Progress(val progress: Int, val total: Int) : UIState()
    object Loading : UIState()
    class Error(val errorMessage: String) : UIState()
}