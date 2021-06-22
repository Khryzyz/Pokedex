package com.chris.pokedex.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class MoveModel(
    val id: Int,
    val name: String,
    val accuracy: Int,
    val power: Int,
    val pp: Int,
    val type: TypeModel,
    val damageClass: DamageClassModel,
    val contestType: ContestTypeModel,
    val effect: String,

    ) : Serializable, Parcelable {

    companion object {
        val DiffCallBack = object : DiffUtil.ItemCallback<MoveModel>() {
            override fun areItemsTheSame(oldItem: MoveModel, newItem: MoveModel) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: MoveModel, newItem: MoveModel) =
                oldItem == newItem
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MoveModel

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.toInt()
    }

}
