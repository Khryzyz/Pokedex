package com.chris.pokedex.layer.repository.fragment.travel

import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.source.local.dataSource.catched.CatchLocalDataSource
import com.chris.pokedex.source.remote.dataSource.pokemon.PokemonRemoteDataSource
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TravelPokemonRepositoryImp @Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource,
    private val localDataSource: CatchLocalDataSource
) : TravelPokemonRepository {

    override suspend fun getDetailPokemon(listPokemonId: List<Int>): Flow<UIStateDetailPokemon> {
        return remoteDataSource.getDetailPokemon(listPokemonId)
    }

    override suspend fun insertCaughtPokemon(
        pokemonModel: PokemonModel,
        action: Constants.TravelAction
    ) {
        localDataSource.insertCaughtPokemon(
            pokemonModel,
            action
        )
    }
}