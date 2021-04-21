package com.chris.pokedex.source.remote.dto.pokemonFull.ability

import com.squareup.moshi.Json

data class AbilitiesResDto(
    @Json(name = "ability")
    val ability: AbilityResDto,
    @Json(name = "is_hidden")
    val isHidden: Boolean,
    @Json(name = "slot")
    val slot: Int
)