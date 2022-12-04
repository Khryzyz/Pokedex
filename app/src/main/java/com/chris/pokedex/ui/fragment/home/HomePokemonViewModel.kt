package com.chris.pokedex.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chris.pokedex.repository.fragment.list.ListPokemonRepository
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomePokemonViewModel
@Inject constructor(
    private val repository: ListPokemonRepository,
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _listPokemon = MutableLiveData<UIStateListPokemon>()
    val listPokemon: LiveData<UIStateListPokemon>
        get() = _listPokemon

    fun getListPokemon(generation: Constants.Generation) {
        viewModelScope.launch(dispatcher) {
            repository.getListPokemon(generation).collect {
                _listPokemon.postValue(it)
            }
        }
    }

}