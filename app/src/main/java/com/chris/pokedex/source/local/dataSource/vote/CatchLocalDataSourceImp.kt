package com.chris.pokedex.source.local.dataSource.vote

import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.source.local.dao.CatchDao
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.toCatchEntity
import com.chris.pokedex.utils.toListPokemonBasicModel
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatchLocalDataSourceImp
@Inject constructor(
    private val catchDao: CatchDao
) : CatchLocalDataSource {
    override suspend fun insertCaughtPokemon(
        pokemonModel: PokemonModel,
        action: Constants.TinderAction
    ) {
        catchDao.insertCaughtPokemon(pokemonModel.toCatchEntity(action))
    }

    override suspend fun getListPokemon(): Flow<UIStateListPokemon> {

        return flow {
            try {
                emit(UIStateListPokemon.Loading)
                emit(
                    UIStateListPokemon.Success(
                        catchDao.getListPokemon().toListPokemonBasicModel()
                    )
                )
            } catch (ex: Exception) {
                emit(UIStateListPokemon.Error(ex.localizedMessage.toString()))
            }
        }


    }
}