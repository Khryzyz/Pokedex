package com.chris.pokedex.source.remote.dto.pokemonFull.sprite

import com.squareup.moshi.Json

data class GenerationIIIResDto(
    @Json(name = "emerald")
    val image: ImageResDto
)