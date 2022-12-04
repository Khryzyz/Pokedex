package com.chris.pokedex.ui.fragment.catched

import androidx.lifecycle.*
import com.chris.pokedex.repository.fragment.catched.CatchPokemonRepository
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CatchPokemonViewModel
@javax.inject.Inject constructor(
    private val repository: CatchPokemonRepository,
    private val dispatcher: CoroutineDispatcher,
) : ViewModel(), LifecycleObserver {

    private val _listPokemon = MutableLiveData<UIStateListPokemon>()
    val listPokemon: LiveData<UIStateListPokemon>
        get() = _listPokemon

    fun getListPokemon() {
        viewModelScope.launch(dispatcher) {
            repository.getListPokemon().collect {
                _listPokemon.postValue(it)
            }
        }
    }

}