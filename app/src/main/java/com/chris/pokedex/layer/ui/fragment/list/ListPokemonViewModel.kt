package com.chris.pokedex.layer.ui.fragment.list

import androidx.lifecycle.*
import com.chris.pokedex.layer.repository.ListPokemonRepository
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIState
import com.chris.pokedex.utils.uiState.UIStateListPokemonLocal
import com.chris.pokedex.utils.uiState.UIStateListPokemonRemote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListPokemonViewModel
@Inject constructor(
    private val repository: ListPokemonRepository
) : ViewModel(), LifecycleObserver {

    private val _responseLocal = MutableLiveData<UIStateListPokemonLocal>()
    val responseLocal: LiveData<UIStateListPokemonLocal>
        get() = _responseLocal

    private val _responseRemote = MutableLiveData<UIStateListPokemonRemote>()
    val responseRemote: LiveData<UIStateListPokemonRemote>
        get() = _responseRemote

    fun getListPokemonByGeneration(generation: Constants.Generation) {
        viewModelScope.launch(Dispatchers.IO) {
            if (repository.getCountPokemonByGeneration(generation) != 0) {
                getListPokemonByGenerationFromLocal(generation)
            } else {
                getListPokemonByGenerationFromRemote(generation)
            }
        }
    }

    private fun getListPokemonByGenerationFromLocal(generation: Constants.Generation) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getListPokemonByGenerationFromLocal(generation).collect {
                _responseLocal.postValue(it)
            }
        }
    }

    private fun getListPokemonByGenerationFromRemote(generation: Constants.Generation) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getListPokemonByGenerationFromRemote(generation).collect {
                _responseRemote.postValue(it)
            }
        }
    }
}