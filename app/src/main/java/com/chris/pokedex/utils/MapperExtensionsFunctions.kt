package com.chris.pokedex.utils

import com.chris.pokedex.R
import com.chris.pokedex.layer.model.*
import com.chris.pokedex.source.local.entity.GenerationEntity
import com.chris.pokedex.source.local.entity.PokemonEntity
import com.chris.pokedex.source.remote.dto.generation.GenerationResDTO
import com.chris.pokedex.source.remote.dto.generation.PokemonBasicResDto
import com.chris.pokedex.source.remote.dto.move.ContestTypeResDto
import com.chris.pokedex.source.remote.dto.move.DamageClassResDto
import com.chris.pokedex.source.remote.dto.move.MoveResDto
import com.chris.pokedex.source.remote.dto.pokemon.PokemonResDto
import com.chris.pokedex.source.remote.dto.pokemon.moveBasic.MovesBasicResDto
import com.chris.pokedex.source.remote.dto.pokemon.sprite.SpriteResDto
import com.chris.pokedex.source.remote.dto.type.TypeResDto
import com.chris.pokedex.source.remote.dto.type.TypesResDto

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
        moveBasics = movesBasic.movesBasicResDtoToListModel(),
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

//Region MovesBasic

fun List<MovesBasicResDto>.movesBasicResDtoToListModel(): List<MoveBasicModel> {
    return map { it.toModel() }.sortedBy { it.name }
}

fun MovesBasicResDto.toModel(): MoveBasicModel = MoveBasicModel(
    id = moveBasic.url.removePrefix("https://pokeapi.co/api/v2/move/").removeSuffix("/").toInt(),
    name = moveBasic.name,
)

//endregion

//Region Move

fun MoveResDto.toModel(): MoveModel = MoveModel(
    id = id,
    name = name,
    accuracy = accuracy ?: 0,
    power = power ?: 0,
    pp = pp,
    type = type.toModel(),
    damageClass = damageClass.toModel(),
    contestType = contestType.toModel(),
    effect = effectEntries[0].effect,
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

//Region ContestTypes
fun ContestTypeResDto.toModel(): ContestTypeModel {

    var contestTypeName: Constants.ContestTypes = Constants.ContestTypes.BEAUTY
    var contestTypeImage: Int = R.mipmap.type_contest_beauty

    when (Constants.ContestTypes.valueOf(name.toUpperCase())) {
        Constants.ContestTypes.BEAUTY -> {
            contestTypeName = Constants.ContestTypes.BEAUTY
            contestTypeImage = R.mipmap.type_contest_beauty
        }
        Constants.ContestTypes.CLEVER -> {
            contestTypeName = Constants.ContestTypes.CLEVER
            contestTypeImage = R.mipmap.type_contest_clever
        }
        Constants.ContestTypes.COOL -> {
            contestTypeName = Constants.ContestTypes.COOL
            contestTypeImage = R.mipmap.type_contest_cool
        }
        Constants.ContestTypes.CUTE -> {
            contestTypeName = Constants.ContestTypes.CUTE
            contestTypeImage = R.mipmap.type_contest_cute
        }
        Constants.ContestTypes.TOUGH -> {
            contestTypeName = Constants.ContestTypes.TOUGH
            contestTypeImage = R.mipmap.type_contest_tough
        }
    }

    return ContestTypeModel(
        contestTypeName = contestTypeName,
        contestTypeImage = contestTypeImage
    )
}
//endregion

//Region DamageClasses
fun DamageClassResDto.toModel(): DamageClassModel {

    var damageClassName: Constants.DamageClasses = Constants.DamageClasses.PHYSICAL
    var damageClassImage: Int = R.mipmap.type_damage_physical

    when (Constants.DamageClasses.valueOf(name.toUpperCase())) {
        Constants.DamageClasses.PHYSICAL -> {
            damageClassName = Constants.DamageClasses.PHYSICAL
            damageClassImage = R.mipmap.type_damage_physical
        }
        Constants.DamageClasses.STATUS -> {
            damageClassName = Constants.DamageClasses.STATUS
            damageClassImage = R.mipmap.type_damage_status
        }
        Constants.DamageClasses.SPECIAL -> {
            damageClassName = Constants.DamageClasses.SPECIAL
            damageClassImage = R.mipmap.type_damage_special
        }
    }

    return DamageClassModel(
        damageClassName = damageClassName,
        damageClassImage = damageClassImage
    )
}
//endregion

//Region Types
fun List<TypesResDto>.typesResDtoToListModel(): List<TypeModel> {
    return map { it.type.toModel() }
}

fun TypeResDto.toModel(): TypeModel {

    var typeName: Constants.Types = Constants.Types.NORMAL
    var typeColor: Int = R.color.type_normal_color
    var typeIcon: Int = R.mipmap.type_normal_icon
    var typeImage: Int = R.mipmap.type_normal_name

    when (Constants.Types.valueOf(name.toUpperCase())) {
        Constants.Types.NORMAL -> {
            typeName = Constants.Types.NORMAL
            typeColor = R.color.type_normal_color
            typeImage = R.mipmap.type_normal_name
            typeIcon = R.mipmap.type_normal_icon
        }
        Constants.Types.FIGHTING -> {
            typeName = Constants.Types.FIGHTING
            typeColor = R.color.type_fighting_color
            typeImage = R.mipmap.type_fighting_name
            typeIcon = R.mipmap.type_fighting_icon
        }
        Constants.Types.FLYING -> {
            typeName = Constants.Types.FLYING
            typeColor = R.color.type_flying_color
            typeImage = R.mipmap.type_flying_name
            typeIcon = R.mipmap.type_flying_icon
        }
        Constants.Types.POISON -> {
            typeName = Constants.Types.POISON
            typeColor = R.color.type_poison_color
            typeImage = R.mipmap.type_poison_name
            typeIcon = R.mipmap.type_poison_icon
        }
        Constants.Types.GROUND -> {
            typeName = Constants.Types.GROUND
            typeColor = R.color.type_ground_color
            typeImage = R.mipmap.type_ground_name
            typeIcon = R.mipmap.type_ground_icon
        }
        Constants.Types.ROCK -> {
            typeName = Constants.Types.ROCK
            typeColor = R.color.type_rock_color
            typeImage = R.mipmap.type_rock_name
            typeIcon = R.mipmap.type_rock_icon
        }
        Constants.Types.BUG -> {
            typeName = Constants.Types.BUG
            typeColor = R.color.type_bug_color
            typeImage = R.mipmap.type_bug_name
            typeIcon = R.mipmap.type_bug_icon
        }
        Constants.Types.GHOST -> {
            typeName = Constants.Types.GHOST
            typeColor = R.color.type_ghost_color
            typeImage = R.mipmap.type_ghost_name
            typeIcon = R.mipmap.type_ghost_icon
        }
        Constants.Types.STEEL -> {
            typeName = Constants.Types.STEEL
            typeColor = R.color.type_steel_color
            typeImage = R.mipmap.type_steel_name
            typeIcon = R.mipmap.type_steel_icon
        }
        Constants.Types.FIRE -> {
            typeName = Constants.Types.FIRE
            typeColor = R.color.type_fire_color
            typeImage = R.mipmap.type_fire_name
            typeIcon = R.mipmap.type_fire_icon
        }
        Constants.Types.WATER -> {
            typeName = Constants.Types.WATER
            typeColor = R.color.type_water_color
            typeImage = R.mipmap.type_water_name
            typeIcon = R.mipmap.type_water_icon
        }
        Constants.Types.GRASS -> {
            typeName = Constants.Types.GRASS
            typeColor = R.color.type_grass_color
            typeImage = R.mipmap.type_grass_name
            typeIcon = R.mipmap.type_grass_icon
        }
        Constants.Types.ELECTRIC -> {
            typeName = Constants.Types.ELECTRIC
            typeColor = R.color.type_electric_color
            typeImage = R.mipmap.type_electric_name
            typeIcon = R.mipmap.type_electric_icon
        }
        Constants.Types.PSYCHIC -> {
            typeName = Constants.Types.PSYCHIC
            typeColor = R.color.type_psychic_color
            typeImage = R.mipmap.type_psychic_name
            typeIcon = R.mipmap.type_psychic_icon
        }
        Constants.Types.ICE -> {
            typeName = Constants.Types.ICE
            typeColor = R.color.type_ice_color
            typeImage = R.mipmap.type_ice_name
            typeIcon = R.mipmap.type_ice_icon
        }
        Constants.Types.DRAGON -> {
            typeName = Constants.Types.DRAGON
            typeColor = R.color.type_dragon_color
            typeImage = R.mipmap.type_dragon_name
            typeIcon = R.mipmap.type_dragon_icon
        }
        Constants.Types.DARK -> {
            typeName = Constants.Types.DARK
            typeColor = R.color.type_dark_color
            typeImage = R.mipmap.type_dark_name
            typeIcon = R.mipmap.type_dark_icon
        }
        Constants.Types.FAIRY -> {
            typeName = Constants.Types.FAIRY
            typeColor = R.color.type_fairy_color
            typeImage = R.mipmap.type_fairy_name
            typeIcon = R.mipmap.type_fairy_icon
        }
        Constants.Types.UNKNOWN -> {
            typeName = Constants.Types.UNKNOWN
            typeColor = R.color.type_unknown_color
            typeImage = R.mipmap.type_normal_name
            typeIcon = R.mipmap.type_normal_icon
        }
        Constants.Types.SHADOW -> {
            typeName = Constants.Types.SHADOW
            typeColor = R.color.type_poison_color
            typeImage = R.mipmap.type_poison_name
            typeIcon = R.mipmap.type_poison_icon
        }

    }

    return TypeModel(
        typeName = typeName,
        typeImage = typeImage,
        typeIcon = typeIcon,
        typeColor = typeColor
    )
}
//endregion
