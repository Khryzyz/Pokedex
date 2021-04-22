package com.chris.pokedex.layer.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
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

    val typeA: String,

    val typeB: String,

    val sprites: List<SpriteModel>,

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
