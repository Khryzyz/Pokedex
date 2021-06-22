package com.chris.pokedex.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class GenerationModel(
    val id: Int,
    val name: String,
    val listPokemonBasicModel: List<PokemonBasicModel>,
) : Parcelable