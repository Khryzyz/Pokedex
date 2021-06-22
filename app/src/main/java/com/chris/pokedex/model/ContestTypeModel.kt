package com.chris.pokedex.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.chris.pokedex.utils.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContestTypeModel(
    val contestTypeName: Constants.ContestTypes,
    @DrawableRes val contestTypeImage: Int
) : Parcelable