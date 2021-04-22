package com.chris.pokedex.source.remote.dto.pokemon.type

import com.squareup.moshi.Json

data class TypesResDto(
    @Json(name = "slot")
    val slot: Int,
    @Json(name = "type")
    val type: TypeResDto
)