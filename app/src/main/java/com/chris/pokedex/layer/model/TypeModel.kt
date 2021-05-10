package com.chris.pokedex.layer.model

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Parcelable
import com.chris.pokedex.utils.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeModel(
    val slot: Int,
    val typeName: Constants.Types,
    val typeImage: Int,
    val typeColor: Int
) : Parcelable {}