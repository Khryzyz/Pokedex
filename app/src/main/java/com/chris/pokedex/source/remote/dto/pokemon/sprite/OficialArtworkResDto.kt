package com.chris.pokedex.source.remote.dto.pokemon.sprite

import com.squareup.moshi.Json

data class OficialArtworkResDto(
    @Json(name = "official-artwork")
    val image: ImageResDto
)