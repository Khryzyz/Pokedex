package com.chris.pokedex.utils

import com.chris.pokedex.layer.model.GenerationModel
import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.layer.model.PokemonModel
import com.chris.pokedex.source.local.entity.GenerationEntity
import com.chris.pokedex.source.local.entity.PokemonEntity
import com.chris.pokedex.source.remote.dto.generation.GenerationResDTO
import com.chris.pokedex.source.remote.dto.generation.PokemonBasicResDto
import com.chris.pokedex.source.remote.dto.pokemon.PokemonResDto

//Region Generation
fun GenerationResDTO.toModel(): GenerationModel = GenerationModel(
    id = id,
    name = name,
    listPokemonBasicModel = pokemonBasicResDto.toListModel()
)

fun List<PokemonBasicResDto>.toListModel(): List<PokemonBasicModel> {
    return map { it.toModel() }
}

fun PokemonBasicResDto.toModel(): PokemonBasicModel = PokemonBasicModel(
    name = name,
    url = url
)

fun GenerationResDTO.toEntity(): GenerationEntity = GenerationEntity(
    id = 0,
    webId = id,
    name = name
)

//endregion

fun PokemonResDto.toEntity(generationId: Long): PokemonEntity {
    return PokemonEntity(
        id = 0,
        webId = id,
        name = name,
        order = order,
        height = height,
        weight = weight,
        generationId = generationId

    )

}

fun List<PokemonEntity>.toModelList(): List<PokemonModel> {
    return map { it.toModel() }
}

fun PokemonEntity.toModel(): PokemonModel = PokemonModel(
    id = id,
    webId = webId,
    name = name,
    order = order,
    height = height,
    weight = weight,
    generationId = generationId
)