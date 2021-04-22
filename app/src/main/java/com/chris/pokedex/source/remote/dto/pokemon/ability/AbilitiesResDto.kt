package com.chris.pokedex.source.remote.dto.pokemon.ability

import com.squareup.moshi.Json

data class AbilitiesResDto(
    @Json(name = "ability")
    val ability: AbilityBasicResDto,
    @Json(name = "is_hidden")
    val isHidden: Boolean,
    @Json(name = "slot")
    val slot: Int
)