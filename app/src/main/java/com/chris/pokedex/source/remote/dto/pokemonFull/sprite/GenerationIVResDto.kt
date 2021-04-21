package com.chris.pokedex.source.remote.dto.pokemonFull.sprite

import com.squareup.moshi.Json

data class GenerationIVResDto(
    @Json(name = "platinum")
    val image: ImageResDto
)