package com.chris.pokedex.layer.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.chris.pokedex.source.local.DBConstants
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonModel(
    val id: Long,

    val webId: Int,

    val name: String,

    val order: Int,

    val height: Int,

    val weight: Int,

    val generationId: Long,

) : Parcelable {

    companion object {

        val DiffCallBack = object : DiffUtil.ItemCallback<PokemonModel>() {

            override fun areItemsTheSame(oldItem: PokemonModel, newItem: PokemonModel) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: PokemonModel, newItem: PokemonModel) =
                oldItem == newItem

        }

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PokemonModel

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.toInt()
    }

}
