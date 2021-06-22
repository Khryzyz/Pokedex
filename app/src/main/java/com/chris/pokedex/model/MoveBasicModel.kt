package com.chris.pokedex.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class MoveBasicModel(
    val id: Int,
    val name: String
) : Serializable, Parcelable {

    companion object {
        val DiffCallBack = object : DiffUtil.ItemCallback<MoveBasicModel>() {
            override fun areItemsTheSame(oldItem: MoveBasicModel, newItem: MoveBasicModel) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MoveBasicModel, newItem: MoveBasicModel) =
                oldItem == newItem
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MoveBasicModel

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }

}
