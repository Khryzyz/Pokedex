package com.chris.pokedex.layer.repository

import com.chris.pokedex.source.local.dataSource.pokemon.PokemonLocalDataSource
import com.chris.pokedex.source.remote.dataSource.pokemon.PokemonRemoteDataSource
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.toEntity
import com.chris.pokedex.utils.toModel
import com.chris.pokedex.utils.toModelList
import com.chris.pokedex.utils.uiState.UIStateListPokemonLocal
import com.chris.pokedex.utils.uiState.UIStateListPokemonRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListPokemonRepositoryImp
@Inject constructor(
    private val localDataSource: PokemonLocalDataSource,
    private val remoteDataSource: PokemonRemoteDataSource
) : ListPokemonRepository {


    //region Local Data
    override suspend fun getCountPokemonByGeneration(generationId: Constants.Generation): Int {
        return localDataSource.getCountPokemonByGeneration(generationId)

    }

    override suspend fun getListPokemonByGenerationFromLocal(generation: Constants.Generation): Flow<UIStateListPokemonLocal> {
        return flow {
            try {
                emit(UIStateListPokemonLocal.Load)
                emit(
                    UIStateListPokemonLocal.Success(
                        localDataSource.getListPokemonByGeneration(
                            generation
                        ).toModelList()
                    )
                )
            } catch (e: Exception) {
                emit(UIStateListPokemonLocal.Error(e.localizedMessage ?: "Something happen"))
            }
        }
    }

    //end Region

    //region Remote Data

    override suspend fun getListPokemonByGenerationFromRemote(generation: Constants.Generation): Flow<UIStateListPokemonRemote> {

        return flow {

            try {

                emit(UIStateListPokemonRemote.Load)

                val responseGeneration = remoteDataSource.getListPokemonByGeneration(generation)

                if (responseGeneration.isSuccessful) {

                    responseGeneration.body()?.let { generationResDTO ->

                        val generationId =
                            localDataSource.insertGeneration(generationResDTO.toEntity())

                        val listPokemonBasicModel = generationResDTO.toModel().listPokemonBasicModel

                        listPokemonBasicModel.forEachIndexed { index, pokemonBasicModel ->

                            emit(
                                UIStateListPokemonRemote.Progress(
                                    index,
                                    listPokemonBasicModel.size
                                )
                            )

                            val responsePokemon =
                                remoteDataSource.getInfoPokemonByName(pokemonBasicModel.name)

                            if (responsePokemon.isSuccessful) {

                                responsePokemon.body()?.let { pokemonResDto ->

                                    localDataSource.insertPokemon(
                                        pokemonResDto.toEntity(
                                            generationId
                                        )
                                    )

                                }

                            } else {

                                emit(UIStateListPokemonRemote.Error("General Error"))

                            }

                        }

                        emit(UIStateListPokemonRemote.Success("Success"))

                    }

                } else {

                    emit(UIStateListPokemonRemote.Error("General Error"))

                }

            } catch (ex: Exception) {

                emit(UIStateListPokemonRemote.Error(ex.localizedMessage))

            }

        }

    }

//endregion

}

