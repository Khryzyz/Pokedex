package com.chris.pokedex.source.remote.dto.pokemonBasic

import com.squareup.moshi.Json

data class PokemonBasicResDto(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "order")
    val order: Int = 0,
    @Json(name = "url")
    val url: String = ""
)