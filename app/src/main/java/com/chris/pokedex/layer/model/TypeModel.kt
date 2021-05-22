package com.chris.pokedex.layer.model

import android.graphics.Color
import android.graphics.drawable.Drawable
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
) : Parcelable {}