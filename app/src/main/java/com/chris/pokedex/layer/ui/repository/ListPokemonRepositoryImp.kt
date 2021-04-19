package com.chris.pokedex.layer.ui.repository

import com.chris.pokedex.source.local.dataSource.pokemon.PokemonLocalDataSource
import com.chris.pokedex.source.remote.dataSource.pokemon.PokemonRemoteDataSource
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.UIState
import com.chris.pokedex.utils.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListPokemonRepositoryImp
@Inject constructor(
    private val localDataSource: PokemonLocalDataSource,
    private val remoteDataSource: PokemonRemoteDataSource
) : ListPokemonRepository {

    //region Remote Data
    override suspend fun getListPokemonByGeneration(generation: Constants.Generation): Flow<UIState> {
        return flow {
            try {
                emit(UIState.Load)
                val response = remoteDataSource.getListPokemonByGeneration(generation)
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(UIState.Success(it.toModel()))
                    }

                } else {
                    emit(UIState.Error("General Error"))
                }
            } catch (ex: Exception) {
                emit(UIState.Error(ex.localizedMessage))
            }
        }
    }
    //endregion

}