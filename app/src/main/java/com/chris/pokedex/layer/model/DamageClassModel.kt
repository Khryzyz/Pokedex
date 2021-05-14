package com.chris.pokedex.layer.model

import android.os.Parcelable
import com.chris.pokedex.utils.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
data class DamageClassModel(
    val damageClassName: Constants.DamageClasses,
    val damageClassImage: Int
) : Parcelable {}