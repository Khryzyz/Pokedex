package com.chris.pokedex.source.remote.dto.pokemonFull.move

import com.squareup.moshi.Json

data class MovesResDto(
    @Json(name = "move")
    val move: MoveBasicResDto,
)