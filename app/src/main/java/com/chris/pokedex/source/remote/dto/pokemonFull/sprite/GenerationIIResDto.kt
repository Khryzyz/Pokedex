package com.chris.pokedex.source.remote.dto.pokemonFull.sprite

import com.squareup.moshi.Json

data class GenerationIIResDto(
    @Json(name = "crystal")
    val image: ImageResDto
)