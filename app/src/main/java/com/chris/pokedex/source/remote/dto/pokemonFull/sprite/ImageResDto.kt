package com.chris.pokedex.source.remote.dto.pokemonFull.sprite

import com.squareup.moshi.Json

data class ImageResDto(
    @Json(name = "front_default")
    val frontDefault: String
)