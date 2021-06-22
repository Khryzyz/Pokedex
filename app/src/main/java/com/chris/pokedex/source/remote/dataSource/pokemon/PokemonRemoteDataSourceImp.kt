package com.chris.pokedex.source.remote.dataSource.pokemon

import android.util.Log
import com.chris.pokedex.model.PokemonBasicModel
import com.chris.pokedex.source.remote.Api
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.pokemonBasicResDtoToListModel
import com.chris.pokedex.utils.toModel
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRemoteDataSourceImp
@Inject constructor(
    private val api: Api
) : PokemonRemoteDataSource {

    override suspend fun getListPokemon(generation: Constants.Generation): Flow<UIStateListPokemon> {
        return flow {
            try {
                emit(UIStateListPokemon.Loading)
                val response = api.getListPokemon(generation.id)
                if (response.isSuccessful) {
                    response.body()?.let { generationResDTO ->
                        emit(
                            UIStateListPokemon.Success(
                                generationResDTO.pokemonBasicResDto
                                    .pokemonBasicResDtoToListModel(generationResDTO.id)
                            )
                        )
                    }
                } else {
                    emit(UIStateListPokemon.Error(response.errorBody().toString()))
                }
            } catch (ex: Exception) {
                emit(UIStateListPokemon.Error(ex.message.toString()))
            }
        }
    }

    override suspend fun getDetailPokemon(pokemonBasicModel: PokemonBasicModel): Flow<UIStateDetailPokemon> {
        return flow {
            try {
                emit(UIStateDetailPokemon.Loading)
                val response = api.getDetailPokemon(pokemonBasicModel.id)
                if (response.isSuccessful) {
                    response.body()?.let { pokemonResDTO ->
                        emit(UIStateDetailPokemon.Success(pokemonResDTO.toModel(pokemonBasicModel)))
                    }
                } else {
                    emit(UIStateDetailPokemon.Error(response.errorBody().toString()))
                }
            } catch (ex: Exception) {
                emit(UIStateDetailPokemon.Error(ex.message.toString()))
            }
        }
    }

    override suspend fun getDetailPokemon(listPokemonId: List<Int>): Flow<UIStateDetailPokemon> {
        return flow {
            try {
                emit(UIStateDetailPokemon.Loading)
                listPokemonId.forEachIndexed { index, item ->
                    Log.e("getDetailPokemon", "index: $index total:${listPokemonId.size}")
                    val response = api.getDetailPokemon(item)
                    if (response.isSuccessful) {
                        response.body()?.let { pokemonResDTO ->
                            emit(
                                UIStateDetailPokemon.Progress(
                                    progress = index + 1,
                                    total = listPokemonId.size,
                                    pokemonModel = pokemonResDTO.toModel(null)
                                )
                            )
                        }
                    } else {
                        emit(
                            UIStateDetailPokemon.Error(
                                response.errorBody().toString()
                            )
                        )
                    }
                }
            } catch (ex: Exception) {
                emit(UIStateDetailPokemon.Error(ex.message.toString()))
            }
        }
    }

}