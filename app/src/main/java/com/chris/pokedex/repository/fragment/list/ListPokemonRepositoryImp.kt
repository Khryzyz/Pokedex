package com.chris.pokedex.repository.fragment.list

import com.chris.pokedex.source.remote.dataSource.pokemon.PokemonRemoteDataSource
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListPokemonRepositoryImp
@Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource
) : ListPokemonRepository {
    override fun getListPokemon(generation: Constants.Generation): Flow<UIStateListPokemon> {
        return remoteDataSource.getListPokemon(generation)
    }
}

