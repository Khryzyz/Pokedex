package com.chris.pokedex.ui.fragment.travel

import androidx.lifecycle.*
import com.chris.pokedex.model.PokemonModel
import com.chris.pokedex.model.TravelCardPokemonModel
import com.chris.pokedex.repository.fragment.travel.TravelPokemonRepository
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.security.SecureRandom
import javax.inject.Inject

class TravelPokemonViewModel
@Inject constructor(
    private val repository: TravelPokemonRepository,
    private val dispatcher: CoroutineDispatcher,
) : ViewModel(), LifecycleObserver {

    private val _travelCardPokemon = MutableLiveData<TravelCardPokemonModel>()
    val travelCardPokemonModel: LiveData<TravelCardPokemonModel>
        get() = _travelCardPokemon

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
        viewModelScope.launch(dispatcher) {
            _listPokemonId.value?.let { listId ->
                repository.getDetailPokemon(listId).collect {
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

    fun swipe(travelAction: Constants.TravelAction, pokemonModel: PokemonModel?) {
        viewModelScope.launch(dispatcher) {
            pokemonModel?.let {
                repository.insertCaughtPokemon(
                    it,
                    travelAction
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
            _travelCardPokemon.value = TravelCardPokemonModel(
                topCardPokemon = if (list.size >= 1) list.last() else null,
                bottomCardPokemon = if (list.size >= 2) list[list.lastIndex - 1] else null
            )
        }
    }
}