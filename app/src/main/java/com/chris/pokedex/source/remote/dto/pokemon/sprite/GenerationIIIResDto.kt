package com.chris.pokedex.source.remote.dto.pokemon.sprite

import com.squareup.moshi.Json

data class GenerationIIIResDto(
    @Json(name = "ruby-sapphire")
    val image: ImageResDto?
)