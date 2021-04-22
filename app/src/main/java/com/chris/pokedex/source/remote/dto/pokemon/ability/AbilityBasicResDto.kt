package com.chris.pokedex.source.remote.dto.pokemon.ability

import com.squareup.moshi.Json

data class AbilityBasicResDto(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)