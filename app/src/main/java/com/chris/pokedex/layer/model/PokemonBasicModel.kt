package com.chris.pokedex.layer.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonBasicModel(
    val id: Int = 0,
    val name: String = "",
    val url: String = "",
    val generation: Int = 1
) : Parcelable {

    companion object {

        val DiffCallBack = object : DiffUtil.ItemCallback<PokemonBasicModel>() {

            override fun areItemsTheSame(oldItem: PokemonBasicModel, newItem: PokemonBasicModel) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: PokemonBasicModel,
                newItem: PokemonBasicModel
            ) =
                oldItem == newItem

        }

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PokemonBasicModel

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.toInt()
    }

}