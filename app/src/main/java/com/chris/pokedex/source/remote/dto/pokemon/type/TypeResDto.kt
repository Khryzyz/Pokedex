package com.chris.pokedex.source.remote.dto.pokemon.type

import com.squareup.moshi.Json

data class TypeResDto(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)