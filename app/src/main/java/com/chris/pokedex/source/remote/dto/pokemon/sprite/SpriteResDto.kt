package com.chris.pokedex.source.remote.dto.pokemon.sprite

import com.squareup.moshi.Json

data class SpriteResDto(
    @Json(name = "other")
    val officialArtwork: OfficialArtworkResDto,
    @Json(name = "versions")
    val versionSprite: VersionSpriteResDto
)