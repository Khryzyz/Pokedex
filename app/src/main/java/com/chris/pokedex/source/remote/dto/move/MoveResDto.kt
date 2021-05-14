package com.chris.pokedex.source.remote.dto.move

import com.chris.pokedex.source.remote.dto.type.TypeResDto
import com.squareup.moshi.Json

data class MoveResDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "accuracy")
    val accuracy: Int?,
    @Json(name = "power")
    val power: Int?,
    @Json(name = "pp")
    val pp: Int,
    @Json(name = "type")
    val type: TypeResDto,
    @Json(name = "damage_class")
    val damageClass: DamageClassResDto,
    @Json(name = "contest_type")
    val contestType: ContestTypeResDto,
    @Json(name = "effect_entries")
    val effectEntries: List<EffectEntryResDto>
)