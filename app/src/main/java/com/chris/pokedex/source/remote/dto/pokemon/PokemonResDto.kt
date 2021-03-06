package com.chris.pokedex.source.remote.dto.pokemon

import com.chris.pokedex.source.remote.dto.pokemon.ability.AbilitiesResDto
import com.chris.pokedex.source.remote.dto.pokemon.moveBasic.MovesBasicResDto
import com.chris.pokedex.source.remote.dto.pokemon.sprite.SpriteResDto
import com.chris.pokedex.source.remote.dto.type.TypesResDto
import com.squareup.moshi.Json

data class PokemonResDto(
    @Json(name = "id")
    val webId: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "order")
    val order: Int,
    @Json(name = "height")
    val height: Int,
    @Json(name = "weight")
    val weight: Int,
    @Json(name = "abilities")
    val abilities: List<AbilitiesResDto>,
    @Json(name = "moves")
    val movesBasic: List<MovesBasicResDto>,
    @Json(name = "sprites")
    val sprites: SpriteResDto,
    @Json(name = "types")
    val types: List<TypesResDto>,
)