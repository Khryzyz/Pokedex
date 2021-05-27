package com.chris.pokedex.source.remote

import com.chris.pokedex.source.remote.dto.generation.GenerationResDTO
import com.chris.pokedex.source.remote.dto.move.MoveResDto
import com.chris.pokedex.source.remote.dto.pokemon.PokemonResDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET(ApiConstants.LIST_POKEMON)
    suspend fun getListPokemon(@Path("generationId") generationId: Int): Response<GenerationResDTO>

    @GET(ApiConstants.DETAIL_POKEMON)
    suspend fun getDetailPokemon(@Path("pokemonId") pokemonId: Int): Response<PokemonResDto>

    @GET(ApiConstants.DETAIL_MOVE)
    suspend fun getDetailMove(@Path("moveId") moveId: Int): Response<MoveResDto>
}