package com.chris.pokedex.source.remote

import com.chris.pokedex.source.remote.dto.generation.GenerationResDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET(ApiConstants.DETAIL_GENERATION)
    suspend fun getDetailGeneration(@Path("generation") generationId: Int): Response<GenerationResDTO>
}