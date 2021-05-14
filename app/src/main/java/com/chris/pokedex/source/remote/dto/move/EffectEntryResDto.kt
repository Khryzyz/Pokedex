package com.chris.pokedex.source.remote.dto.move

import com.squareup.moshi.Json

data class EffectEntryResDto(
    @Json(name = "effect")
    val effect: String,
    @Json(name = "short_effect")
    val shortEffect: String
)