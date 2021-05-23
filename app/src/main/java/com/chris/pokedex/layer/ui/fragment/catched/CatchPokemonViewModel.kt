package com.chris.pokedex.layer.ui.fragment.catched

import androidx.lifecycle.*
import com.chris.pokedex.layer.repository.fragment.catchRepository.CatchPokemonRepository
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CatchPokemonViewModel
@javax.inject.Inject constructor(
    private val repository: CatchPokemonRepository
) : ViewModel(), LifecycleObserver {

    private val _listPokemon = MutableLiveData<UIStateListPokemon>()
    val listPokemon: LiveData<UIStateListPokemon>
        get() = _listPokemon

    fun getListPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getListPokemon().collect {
                _listPokemon.postValue(it)
            }
        }
    }

}