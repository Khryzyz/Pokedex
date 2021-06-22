package com.chris.pokedex.model

import android.os.Parcelable
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.chris.pokedex.utils.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeModel(
    val typeName: Constants.Types,
    @DrawableRes val typeImage: Int,
    @DrawableRes val typeIcon: Int,
    @ColorInt val typeColor: Int
) : Parcelable