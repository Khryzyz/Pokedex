package com.chris.pokedex.source.remote.dto.pokemon.sprite

import com.squareup.moshi.Json

data class ImageResDto(
    @Json(name = "front_default")
    val frontDefault: String?
)