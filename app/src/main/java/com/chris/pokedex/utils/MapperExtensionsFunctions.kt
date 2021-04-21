package com.chris.pokedex.utils

import com.chris.pokedex.layer.model.GenerationModel
import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.source.remote.dto.generation.GenerationResDTO
import com.chris.pokedex.source.remote.dto.pokemonBasic.PokemonBasicResDto

fun GenerationResDTO.toModel(): GenerationModel = GenerationModel(
    id = id,
    name = name,
    listPokemonModel = pokemonBasicResDto.toListModel()
)

fun List<PokemonBasicResDto>.toListModel(): List<PokemonModel> {
    return map { it.toModel() }
}

fun PokemonBasicResDto.toModel(): PokemonModel = PokemonModel(
    name = name,
    url = url
)

//endregion