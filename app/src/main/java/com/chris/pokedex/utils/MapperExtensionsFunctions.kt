package com.chris.pokedex.utils

import com.chris.pokedex.R
import com.chris.pokedex.layer.model.*
import com.chris.pokedex.source.local.entity.GenerationEntity
import com.chris.pokedex.source.local.entity.PokemonEntity
import com.chris.pokedex.source.remote.dto.generation.GenerationResDTO
import com.chris.pokedex.source.remote.dto.generation.PokemonBasicResDto
import com.chris.pokedex.source.remote.dto.pokemon.PokemonResDto
import com.chris.pokedex.source.remote.dto.pokemon.move.MovesResDto
import com.chris.pokedex.source.remote.dto.pokemon.sprite.SpriteResDto
import com.chris.pokedex.source.remote.dto.pokemon.type.TypesResDto

//Region Generation
fun GenerationResDTO.toModel(): GenerationModel = GenerationModel(
    id = id,
    name = name.toUpperCase(),
    listPokemonBasicModel = pokemonBasicResDto.pokemonBasicResDtoToListModel(id)
)

fun List<PokemonBasicResDto>.pokemonBasicResDtoToListModel(generationId: Int): List<PokemonBasicModel> {
    return map { it.toModel(generationId) }
}

fun PokemonBasicResDto.toModel(generationId: Int): PokemonBasicModel = PokemonBasicModel(
    id = url.removePrefix("https://pokeapi.co/api/v2/pokemon-species/").removeSuffix("/").toInt(),
    name = name.toUpperCase(),
    url = url,
    generation = generationId
)

fun GenerationResDTO.toEntity(): GenerationEntity = GenerationEntity(
    id = 0,
    webId = id,
    name = name
)

//endregion

//Region Pokemon

fun PokemonResDto.toModel(pokemonBasicModel: PokemonBasicModel): PokemonModel {
    return PokemonModel(
        webId = webId,
        name = name.toUpperCase(),
        order = order,
        height = height,
        weight = weight,
        generationId = pokemonBasicModel.generation.toLong(),
        moves = moves.movesResDtoToListModel(),
        types = types.typesResDtoToListModel(),
        sprites = sprites.toModel(),
    )
}

fun PokemonResDto.toEntity(generationId: Long): PokemonEntity {
    return PokemonEntity(
        id = 0,
        webId = webId,
        name = name.toUpperCase(),
        order = order,
        height = height,
        weight = weight,
        generationId = generationId,
        typeA = types[0].type.name,
        typeB = if (types.size > 1) types[1].type.name else "none",
    )

}

//endregion

//Region Moves

fun List<MovesResDto>.movesResDtoToListModel(): List<MoveModel> {
    return map { it.toModel() }.sortedBy { it.name }
}

fun MovesResDto.toModel(): MoveModel = MoveModel(
    name = move.name,
    url = move.url
)

//endregion

//Region Sprites

fun SpriteResDto.toModel(): SpriteModel {
    return SpriteModel(
        officialArtwork = officialArtwork.image.frontDefault ?: "",
        frontGenerationI = versionSprite.generationI.image?.frontDefault ?: "",
        backGenerationI = versionSprite.generationI.image?.backDefault ?: "",
        frontGenerationII = versionSprite.generationII.image?.frontDefault ?: "",
        backGenerationII = versionSprite.generationII.image?.backDefault ?: "",
        frontGenerationIII = versionSprite.generationIII.image?.frontDefault ?: "",
        backGenerationIII = versionSprite.generationIII.image?.backDefault ?: "",
        frontGenerationIV = versionSprite.generationIV.image?.frontDefault ?: "",
        backGenerationIV = versionSprite.generationIV.image?.backDefault ?: "",
    )
}

//endregion

//Region Types
fun List<TypesResDto>.typesResDtoToListModel(): List<TypeModel> {
    return map { it.toModel() }
}

fun TypesResDto.toModel(): TypeModel {

    var typeName: Constants.Types = Constants.Types.NORMAL
    var typeColor: Int = R.color.type_normal_color
    var typeImage: Int = R.mipmap.type_normal_name

    when (Constants.Types.valueOf(type.name.toUpperCase())) {
        Constants.Types.NORMAL -> {
            typeName = Constants.Types.NORMAL
            typeColor = R.color.type_normal_color
            typeImage = R.mipmap.type_normal_name
        }
        Constants.Types.FIGHTING -> {
            typeName = Constants.Types.FIGHTING
            typeColor = R.color.type_fighting_color
            typeImage = R.mipmap.type_fighting_name
        }
        Constants.Types.FLYING -> {
            typeName = Constants.Types.FLYING
            typeColor = R.color.type_flying_color
            typeImage = R.mipmap.type_flying_name
        }
        Constants.Types.POISON -> {
            typeName = Constants.Types.POISON
            typeColor = R.color.type_poison_color
            typeImage = R.mipmap.type_poison_name
        }
        Constants.Types.GROUND -> {
            typeName = Constants.Types.GROUND
            typeColor = R.color.type_ground_color
            typeImage = R.mipmap.type_ground_name
        }
        Constants.Types.ROCK -> {
            typeName = Constants.Types.ROCK
            typeColor = R.color.type_rock_color
            typeImage = R.mipmap.type_rock_name
        }
        Constants.Types.BUG -> {
            typeName = Constants.Types.BUG
            typeColor = R.color.type_bug_color
            typeImage = R.mipmap.type_bug_name
        }
        Constants.Types.GHOST -> {
            typeName = Constants.Types.GHOST
            typeColor = R.color.type_ghost_color
            typeImage = R.mipmap.type_ghost_name
        }
        Constants.Types.STEEL -> {
            typeName = Constants.Types.STEEL
            typeColor = R.color.type_steel_color
            typeImage = R.mipmap.type_steel_name
        }
        Constants.Types.FIRE -> {
            typeName = Constants.Types.FIRE
            typeColor = R.color.type_fire_color
            typeImage = R.mipmap.type_fire_name
        }
        Constants.Types.WATER -> {
            typeName = Constants.Types.WATER
            typeColor = R.color.type_water_color
            typeImage = R.mipmap.type_water_name
        }
        Constants.Types.GRASS -> {
            typeName = Constants.Types.GRASS
            typeColor = R.color.type_grass_color
            typeImage = R.mipmap.type_grass_name
        }
        Constants.Types.ELECTRIC -> {
            typeName = Constants.Types.ELECTRIC
            typeColor = R.color.type_electric_color
            typeImage = R.mipmap.type_electric_name
        }
        Constants.Types.PSYCHIC -> {
            typeName = Constants.Types.PSYCHIC
            typeColor = R.color.type_psychic_color
            typeImage = R.mipmap.type_psychic_name
        }
        Constants.Types.ICE -> {
            typeName = Constants.Types.ICE
            typeColor = R.color.type_ice_color
            typeImage = R.mipmap.type_ice_name
        }
        Constants.Types.DRAGON -> {
            typeName = Constants.Types.DRAGON
            typeColor = R.color.type_dragon_color
            typeImage = R.mipmap.type_dragon_name
        }
        Constants.Types.DARK -> {
            typeName = Constants.Types.DARK
            typeColor = R.color.type_dark_color
            typeImage = R.mipmap.type_dark_name
        }
        Constants.Types.FAIRY -> {
            typeName = Constants.Types.FAIRY
            typeColor = R.color.type_fairy_color
            typeImage = R.mipmap.type_fairy_name
        }
        Constants.Types.UNKNOWN -> {
            typeName = Constants.Types.UNKNOWN
            typeColor = R.color.type_unknown_color
            typeImage = R.mipmap.type_normal_name
        }
        Constants.Types.SHADOW -> {
            typeName = Constants.Types.SHADOW
            typeColor = R.color.type_poison_color
            typeImage = R.mipmap.type_poison_name
        }

    }

    return TypeModel(
        slot = slot,
        typeName = typeName,
        typeImage = typeImage,
        typeColor = typeColor
    )
}
//endregion
