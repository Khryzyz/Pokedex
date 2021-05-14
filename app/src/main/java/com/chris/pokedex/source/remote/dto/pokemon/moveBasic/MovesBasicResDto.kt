package com.chris.pokedex.source.remote.dto.pokemon.moveBasic

import com.squareup.moshi.Json

data class MovesBasicResDto(
    @Json(name = "move")
    val moveBasic: MoveBasicResDto,
)