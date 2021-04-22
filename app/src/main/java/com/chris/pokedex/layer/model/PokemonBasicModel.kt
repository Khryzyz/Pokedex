package com.chris.pokedex.layer.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonBasicModel(
    val name: String = "",
    val url: String = ""
) : Parcelable {

    companion object {

        val DiffCallBack = object : DiffUtil.ItemCallback<PokemonBasicModel>() {

            override fun areItemsTheSame(oldItem: PokemonBasicModel, newItem: PokemonBasicModel) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: PokemonBasicModel, newItem: PokemonBasicModel) =
                oldItem == newItem

        }

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PokemonBasicModel

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.toInt()
    }

}
