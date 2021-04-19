package com.chris.pokedex.layer.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class GenerationModel(
    val id: Int,
    val name: String,
    val pokemonModel: List<PokemonModel>,
) : Parcelable