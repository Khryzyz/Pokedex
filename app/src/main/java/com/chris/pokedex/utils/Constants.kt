package com.chris.pokedex.utils

import java.io.Serializable

class Constants {

    object BundleKeys {
        const val GENERATION = "generation"
    }

    enum class Generation constructor(val id: Int) : Serializable {
        FIRST(1),
        SECOND(2),
        THIRD(3),
        FOURTH(4)
    }
}