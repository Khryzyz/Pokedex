package com.chris.pokedex.layer.ui.fragment.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.layer.repository.fragment.detail.DetailPokemonRepository
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailPokemonViewModel
@Inject constructor(
    private val repository: DetailPokemonRepository
) : ViewModel() {


    private val _pokemon = MutableLiveData<UIStateDetailPokemon>()
    val pokemon: LiveData<UIStateDetailPokemon>
        get() = _pokemon

    fun getDetailPokemon(pokemonBasicModel: PokemonBasicModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDetailPokemon(pokemonBasicModel).collect {
                _pokemon.postValue(it)
            }
        }
    }

}