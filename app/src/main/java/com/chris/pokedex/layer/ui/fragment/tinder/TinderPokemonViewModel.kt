package com.chris.pokedex.layer.ui.fragment.tinder

import androidx.lifecycle.*
import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.layer.model.TinderCardPokemonModel
import com.chris.pokedex.layer.repository.fragment.detail.DetailPokemonRepository
import com.chris.pokedex.layer.repository.fragment.catchRepository.CatchPokemonRepository
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.security.SecureRandom
import javax.inject.Inject

class TinderPokemonViewModel
@Inject constructor(
    private val detailPokemonRepository: DetailPokemonRepository,
    private val catchPokemonRepository: CatchPokemonRepository
) : ViewModel(), LifecycleObserver {

    private val _tinderCardPokemon = MutableLiveData<TinderCardPokemonModel>()
    val tinderCardPokemonModel: LiveData<TinderCardPokemonModel>
        get() = _tinderCardPokemon

    private val _listDetailPokemon = MutableLiveData<MutableList<PokemonModel>?>()
    val listDetailPokemon: LiveData<MutableList<PokemonModel>?>
        get() = _listDetailPokemon

    private val _pokemon = MutableLiveData<UIStateDetailPokemon>()
    val pokemon: LiveData<UIStateDetailPokemon>
        get() = _pokemon

    private var _listPokemonId = MutableLiveData<MutableList<Int>>()

    private val random = SecureRandom()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun generateListPokemon() {

        random.setSeed(random.generateSeed(20))

        val listRandom = mutableListOf<Int>()

        for (i in 1..10) {
            listRandom.add(random.nextInt(493) + 1)
        }

        _listPokemonId.value = listRandom
        getDetailPokemon()
    }

    private fun getDetailPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            _listPokemonId.value?.let { listId ->
                detailPokemonRepository.getDetailPokemon(listId).collect {
                    _pokemon.postValue(it)
                }
            }
        }
    }

    fun addItemListPokemonDetail(pokemonModel: PokemonModel) {

        val list: MutableList<PokemonModel>?

        if (_listDetailPokemon.value != null) {
            list = _listDetailPokemon.value
            list?.add(pokemonModel)
        } else {
            list = mutableListOf(pokemonModel)
        }

        list.let {
            _listDetailPokemon.value = list
        }
    }

    fun swipe(tinderAction: Constants.TinderAction, pokemonModel: PokemonModel?) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonModel?.let {
                catchPokemonRepository.insertCaughtPokemon(
                    it,
                    tinderAction
                )
            }
        }

        _listDetailPokemon.value?.let { list ->
            list.removeLastOrNull()
            updateCard()
        }
    }

    fun updateCard() {
        _listDetailPokemon.value?.let { list ->
            _tinderCardPokemon.value = TinderCardPokemonModel(
                topCardPokemon = if (list.size >= 1) list.last() else null,
                bottomCardPokemon = if (list.size >= 2) list[list.lastIndex - 1] else null
            )
        }
    }
}