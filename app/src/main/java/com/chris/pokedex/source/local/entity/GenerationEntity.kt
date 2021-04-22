package com.chris.pokedex.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chris.pokedex.source.local.DBConstants
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = DBConstants.Generation.TABLE_NAME)
data class GenerationEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBConstants.Generation.COLUMN_ID, index = true)
    val id: Long,

    @ColumnInfo(name = DBConstants.Generation.COLUMN_WEB_ID)
    val webId: Int,

    @ColumnInfo(name = DBConstants.Generation.COLUMN_NAME)
    val name: String

) : Parcelable {}