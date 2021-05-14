package com.chris.pokedex.source.remote.dto.type

import com.squareup.moshi.Json

data class TypesResDto(
    @Json(name = "slot")
    val slot: Int,
    @Json(name = "type")
    val type: TypeResDto
)