package com.chris.pokedex.source.remote.dto.pokemon.sprite

import com.squareup.moshi.Json

data class GenerationIResDto(
    @Json(name = "yellow")
    val image: ImageResDto?
)