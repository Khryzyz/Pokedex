package com.chris.pokedex.source.remote.dataSource.pokemon

import com.chris.pokedex.layer.model.PokemonBasicModel
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
                                    .sortedBy { it.id }
                            )
                        )
                    }
                } else {
                    emit(UIStateListPokemon.Error(response.errorBody().toString()))
                }
            } catch (ex: Exception) {
                emit(UIStateListPokemon.Error(ex.localizedMessage.toString()))
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
                emit(UIStateDetailPokemon.Error(ex.localizedMessage.toString()))
            }
        }
    }

}