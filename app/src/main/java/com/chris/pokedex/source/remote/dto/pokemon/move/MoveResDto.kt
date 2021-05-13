package com.chris.pokedex.source.remote.dto.pokemon.move

import com.squareup.moshi.Json

data class MoveResDto(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)