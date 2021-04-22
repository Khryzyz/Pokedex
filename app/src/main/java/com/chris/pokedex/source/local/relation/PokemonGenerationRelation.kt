package com.chris.pokedex.source.local.relation

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import com.chris.pokedex.source.local.DBConstants
import com.chris.pokedex.source.local.entity.GenerationEntity
import com.chris.pokedex.source.local.entity.PokemonEntity
import kotlinx.parcelize.Parcelize

@Parcelize
class PokemonGenerationRelation(

    @Embedded
    val pokemonEntity: PokemonEntity,

    @Relation(
        entity = GenerationEntity::class,
        entityColumn = DBConstants.Generation.COLUMN_ID,
        parentColumn = DBConstants.Pokemon.COLUMN_GENERATION_ID
    )
    var generationEntity: GenerationEntity,

    ) : Parcelable