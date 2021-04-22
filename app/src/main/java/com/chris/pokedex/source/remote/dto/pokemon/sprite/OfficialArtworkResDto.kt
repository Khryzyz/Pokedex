package com.chris.pokedex.source.remote.dto.pokemon.sprite

import com.squareup.moshi.Json

data class OfficialArtworkResDto(
    @Json(name = "official-artwork")
    val image: ImageResDto
)