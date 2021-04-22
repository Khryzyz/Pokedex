package com.chris.pokedex.layer.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpriteModel(
    val officialArtwor: String,
    val generationI: String = "",
    val generationII: String = "",
    val generationIII: String = "",
    val generationIV: String = "",

    ) : Parcelable {}