package com.chris.pokedex.source.remote.dataSource.pokemon

import com.chris.pokedex.source.remote.dto.generation.GenerationResDTO
import com.chris.pokedex.source.remote.dto.pokemon.PokemonResDto
import com.chris.pokedex.utils.Constants
import retrofit2.Response

interface PokemonRemoteDataSource {
    suspend fun getListPokemonByGeneration(generation: Constants.Generation): Response<GenerationResDTO>
    suspend fun getInfoPokemonByName(pokemonName: String): Response<PokemonResDto>
}