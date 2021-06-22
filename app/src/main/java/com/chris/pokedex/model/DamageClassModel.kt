package com.chris.pokedex.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.chris.pokedex.utils.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
data class DamageClassModel(
    val damageClassName: Constants.DamageClasses,
    @DrawableRes val damageClassImage: Int
) : Parcelable