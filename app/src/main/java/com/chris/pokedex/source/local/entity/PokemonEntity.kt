package com.chris.pokedex.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.chris.pokedex.source.local.DBConstants
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    tableName = DBConstants.Pokemon.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = GenerationEntity::class,
            parentColumns = [DBConstants.Generation.COLUMN_ID],
            childColumns = [DBConstants.Pokemon.COLUMN_GENERATION_ID],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
        ),
    ]
)
data class PokemonEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBConstants.Pokemon.COLUMN_ID, index = true)
    val id: Long,

    @ColumnInfo(name = DBConstants.Pokemon.COLUMN_WEB_ID)
    val webId: Int,

    @ColumnInfo(name = DBConstants.Pokemon.COLUMN_NAME)
    val name: String,

    @ColumnInfo(name = DBConstants.Pokemon.COLUMN_ORDER)
    val order: Int,

    @ColumnInfo(name = DBConstants.Pokemon.COLUMN_HEIGHT)
    val height: Int,

    @ColumnInfo(name = DBConstants.Pokemon.COLUMN_WEIGHT)
    val weight: Int,

    @ColumnInfo(name = DBConstants.Pokemon.COLUMN_GENERATION_ID)
    val generationId: Long,

    ) : Parcelable