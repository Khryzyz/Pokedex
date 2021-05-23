package com.chris.pokedex.layer.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpriteModel(
    val officialArtwork: String,
    val frontGenerationI: String = "",
    val backGenerationI: String = "",
    val frontGenerationII: String = "",
    val backGenerationII: String = "",
    val frontGenerationIII: String = "",
    val backGenerationIII: String = "",
    val frontGenerationIV: String = "",
    val backGenerationIV: String = "",
) : Parcelable