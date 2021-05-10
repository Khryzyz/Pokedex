package com.chris.pokedex.layer.ui.fragment.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chris.pokedex.layer.repository.list.ListPokemonRepository
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListPokemonViewModel
@Inject constructor(
    private val repository: ListPokemonRepository
) : ViewModel() {

    private val _generation = MutableLiveData<UIStateListPokemon>()
    val generation: LiveData<UIStateListPokemon>
        get() = _generation

    fun getListPokemon(generation: Constants.Generation) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getListPokemon(generation).collect {
                _generation.postValue(it)
            }
        }
    }

}