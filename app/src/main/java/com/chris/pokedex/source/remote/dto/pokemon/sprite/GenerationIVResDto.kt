package com.chris.pokedex.source.remote.dto.pokemon.sprite

import com.squareup.moshi.Json

data class GenerationIVResDto(
    @Json(name = "platinum")
    val image: ImageResDto?
)