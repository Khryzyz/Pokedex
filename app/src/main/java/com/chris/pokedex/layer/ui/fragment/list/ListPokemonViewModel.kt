package com.chris.pokedex.layer.ui.fragment.list

import androidx.lifecycle.*
import com.chris.pokedex.layer.repository.ListPokemonRepository
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListPokemonViewModel
@Inject constructor(
    private val repository: ListPokemonRepository
) : ViewModel(), LifecycleObserver {

    private val _responsePost = MutableLiveData<UIState>()
    val responsePost: LiveData<UIState>
        get() = _responsePost

    //region Metodos sobrecargados de la Interfaz
    fun getListPokemonByGeneration(generation: Constants.Generation) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getListPokemonByGeneration(generation).collect {
                _responsePost.postValue(it)
            }
        }
    }

}