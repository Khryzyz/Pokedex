package com.chris.pokedex.layer.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonModel(
    val id: Int = 0,
    val name: String = "",
    val order: Int = 0,
    val url: String = ""
) : Parcelable