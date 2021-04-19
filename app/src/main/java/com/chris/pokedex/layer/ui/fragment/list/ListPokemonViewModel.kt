package com.chris.pokedex.layer.ui.fragment.list

import androidx.lifecycle.*
import com.chris.pokedex.layer.ui.repository.ListPokemonRepository
import com.chris.pokedex.utils.Constants
import javax.inject.Inject

class ListPokemonViewModel
@Inject constructor(
    private val repository: ListPokemonRepository
) : ViewModel(), LifecycleObserver {

    private val _test = MutableLiveData<String>()
    val test: LiveData<String>
        get() = _test

    //region Metodos sobrecargados de la Interfaz
    fun getListPokemonByGeneration(generation: Constants.Generation) {
        _test.postValue(generation.id.toString())
    }

}