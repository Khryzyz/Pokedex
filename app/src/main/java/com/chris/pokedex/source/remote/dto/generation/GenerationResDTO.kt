package com.chris.pokedex.source.remote.dto.generation

import com.chris.pokedex.source.remote.dto.pokemon.PokemonResDto
import com.squareup.moshi.Json

data class GenerationResDTO(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "pokemon_species")
    val pokemonResDto: List<PokemonResDto>,
)