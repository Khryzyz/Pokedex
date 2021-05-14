package com.chris.pokedex.source.remote.dto.move

import com.squareup.moshi.Json

class ContestTypeResDto(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)