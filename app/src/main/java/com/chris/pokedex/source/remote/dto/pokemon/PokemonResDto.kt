package com.chris.pokedex.source.remote.dto.pokemon

import com.squareup.moshi.Json

data class PokemonResDto(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "order")
    val order: Int = 0,
    @Json(name = "url")
    val url: String = ""
)