package com.chris.pokedex.source.remote.dataSource.pokemon

import com.chris.pokedex.source.remote.Api
import com.chris.pokedex.source.remote.dto.generation.GenerationResDTO
import com.chris.pokedex.utils.Constants
import retrofit2.Response
import javax.inject.Inject

class PokemonRemoteDataSourceImp
@Inject constructor(
    private val api: Api
) : PokemonRemoteDataSource {
    override suspend fun getListPokemonByGeneration(generation: Constants.Generation): Response<GenerationResDTO> {
        return api.getDetailGeneration(generation.id)
    }

}