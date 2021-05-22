package com.chris.pokedex.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.chris.pokedex.source.local.DBConstants
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    tableName = DBConstants.Catch.TABLE_NAME,
    indices = [Index(
        value = [DBConstants.Catch.COLUMN_WEB_ID],
        unique = true
    )]
)
data class CatchEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBConstants.Catch.COLUMN_ID, index = true)
    val id: Long,

    @ColumnInfo(name = DBConstants.Catch.COLUMN_WEB_ID)
    val webId: Int,

    @ColumnInfo(name = DBConstants.Catch.COLUMN_NAME)
    val name: String,

    @ColumnInfo(name = DBConstants.Catch.COLUMN_ACTION)
    val action: Int,
) : Parcelable