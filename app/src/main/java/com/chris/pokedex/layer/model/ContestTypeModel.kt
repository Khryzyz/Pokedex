package com.chris.pokedex.layer.model

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.chris.pokedex.utils.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContestTypeModel(
    val contestTypeName: Constants.ContestTypes,
   @DrawableRes val contestTypeImage: Int
) : Parcelable {}