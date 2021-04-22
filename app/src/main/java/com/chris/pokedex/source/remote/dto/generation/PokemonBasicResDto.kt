package com.chris.pokedex.source.remote.dto.generation

import com.squareup.moshi.Json

data class PokemonBasicResDto(

    @Json(name = "name")
    val name: String = "",

    @Json(name = "url")
    val url: String = ""
)