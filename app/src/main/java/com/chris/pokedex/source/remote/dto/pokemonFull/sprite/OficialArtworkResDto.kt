package com.chris.pokedex.source.remote.dto.pokemonFull.sprite

import com.squareup.moshi.Json

data class OficialArtworkResDto(
    @Json(name = "official-artwork")
    val image: ImageResDto
)