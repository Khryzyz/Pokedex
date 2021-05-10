package com.chris.pokedex.layer.repository.list

import com.chris.pokedex.source.local.dataSource.pokemon.PokemonLocalDataSource
import com.chris.pokedex.source.remote.dataSource.pokemon.PokemonRemoteDataSource
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListPokemonRepositoryImp
@Inject constructor(
    private val localDataSource: PokemonLocalDataSource,
    private val remoteDataSource: PokemonRemoteDataSource
) : ListPokemonRepository {

    //region Remote Data

    override suspend fun getListPokemon(generation: Constants.Generation): Flow<UIStateListPokemon> {
        return remoteDataSource.getListPokemon(generation)
    }

    //endregion

}

