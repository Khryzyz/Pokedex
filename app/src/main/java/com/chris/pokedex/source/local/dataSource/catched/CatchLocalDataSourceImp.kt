package com.chris.pokedex.source.local.dataSource.catched

import com.chris.pokedex.model.PokemonModel
import com.chris.pokedex.source.local.dao.CatchDao
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.toCatchEntity
import com.chris.pokedex.utils.toListPokemonBasicModel
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatchLocalDataSourceImp
@Inject constructor(
    private val catchDao: CatchDao
) : CatchLocalDataSource {

    override suspend fun insertCaughtPokemon(
        pokemonModel: PokemonModel,
        action: Constants.TravelAction
    ) {
        catchDao.insertCaughtPokemon(pokemonModel.toCatchEntity(action))
    }

    override fun getListPokemon(): Flow<UIStateListPokemon> {
        return flow {
            emit(UIStateListPokemon.Loading)
            emit(
                UIStateListPokemon.Success(
                    catchDao.getListPokemon().toListPokemonBasicModel()
                )
            )
        }.catch {
            emit(UIStateListPokemon.Error(it.message.toString()))
        }
    }
}