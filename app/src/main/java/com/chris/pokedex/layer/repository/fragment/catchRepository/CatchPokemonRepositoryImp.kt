package com.chris.pokedex.layer.repository.fragment.catchRepository

import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.source.local.dataSource.vote.CatchLocalDataSource
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatchPokemonRepositoryImp @Inject constructor(
    private val localDataSource: CatchLocalDataSource
) : CatchPokemonRepository {
    override suspend fun insertCaughtPokemon(
        pokemonModel: PokemonModel,
        action: Constants.TinderAction
    ) {
        localDataSource.insertCaughtPokemon(
            pokemonModel,
            action
        )
    }

    override suspend fun getListPokemon(): Flow<UIStateListPokemon> {
        return localDataSource.getListPokemon()
    }

}