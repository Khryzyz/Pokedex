package com.chris.pokedex.utils

import com.chris.pokedex.layer.model.GenerationModel
import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.source.remote.dto.generation.GenerationResDTO
import com.chris.pokedex.source.remote.dto.pokemon.PokemonResDto

fun GenerationResDTO.toModel(): GenerationModel = GenerationModel(
    id = id,
    name = name,
    pokemonModel = pokemonResDto.toListModel()
)

fun List<PokemonResDto>.toListModel(): List<PokemonModel> {
    return map { it.toModel() }
}

fun PokemonResDto.toModel(): PokemonModel = PokemonModel(
    name = name,
    url = url
)

//endregion