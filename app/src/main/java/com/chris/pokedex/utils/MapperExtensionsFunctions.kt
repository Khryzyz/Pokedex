package com.chris.pokedex.utils

import com.chris.pokedex.layer.model.GenerationModel
import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.source.local.entity.GenerationEntity
import com.chris.pokedex.source.local.entity.PokemonEntity
import com.chris.pokedex.source.remote.dto.generation.GenerationResDTO
import com.chris.pokedex.source.remote.dto.generation.PokemonBasicResDto
import com.chris.pokedex.source.remote.dto.pokemon.PokemonResDto

//Region Generation
fun GenerationResDTO.toModel(): GenerationModel = GenerationModel(
    id = id,
    name = name,
    listPokemonBasicModel = pokemonBasicResDto.toListModel(id)
)

fun List<PokemonBasicResDto>.toListModel(generationId: Int): List<PokemonBasicModel> {
    return map { it.toModel(generationId) }
}

fun PokemonBasicResDto.toModel(generationId: Int): PokemonBasicModel = PokemonBasicModel(
    id = url.removePrefix("https://pokeapi.co/api/v2/pokemon-species/").removeSuffix("/").toInt(),
    name = name,
    url = url,
    generation = generationId
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
        generationId = generationId,
        typeA = types[0].type.name,
        typeB = if (types.size > 1) types[1].type.name else "none",
    )

}
//
//fun List<PokemonEntity>.toModelList(): List<PokemonModel> {
//    return map { it.toModel() }
//}
//
//fun PokemonEntity.toModel(): PokemonModel = PokemonModel(
//    id = id,
//    webId = webId,
//    name = name,
//    order = order,
//    height = height,
//    weight = weight,
//    generationId = generationId,
//    sprites =
//    typeA = typeA,
//    typeB = typeB
//)