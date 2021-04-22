package com.chris.pokedex.source.remote.dto.pokemon.sprite

import com.squareup.moshi.Json

data class VersionSpriteResDto(
    @Json(name = "generation-i")
    val generationI: GenerationIResDto,
    @Json(name = "generation-ii")
    val generationII: GenerationIIResDto,
    @Json(name = "generation-iii")
    val generationIII: GenerationIIIResDto,
    @Json(name = "generation-iv")
    val generationIV: GenerationIVResDto,
)