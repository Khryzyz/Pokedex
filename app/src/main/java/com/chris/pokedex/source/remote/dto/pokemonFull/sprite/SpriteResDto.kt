package com.chris.pokedex.source.remote.dto.pokemonFull.sprite

import com.squareup.moshi.Json

data class SpriteResDto(
    @Json(name = "other")
    val oficialArtwork: OficialArtworkResDto,
    @Json(name = "versions")
    val versionSprite: VersionSpriteResDto
)