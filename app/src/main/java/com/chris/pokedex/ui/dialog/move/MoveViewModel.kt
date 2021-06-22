package com.chris.pokedex.ui.dialog.move

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chris.pokedex.model.MoveBasicModel
import com.chris.pokedex.repository.dialog.move.MoveRepository
import com.chris.pokedex.utils.uiState.UIStateDetailMove
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoveViewModel
@Inject constructor(
    private val repository: MoveRepository
) : ViewModel() {

    private val _move = MutableLiveData<UIStateDetailMove>()
    val move: LiveData<UIStateDetailMove>
        get() = _move

    fun getDetailMove(moveBasicModel: MoveBasicModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDetailMove(moveBasicModel).collect {
                _move.postValue(it)
            }
        }
    }
}