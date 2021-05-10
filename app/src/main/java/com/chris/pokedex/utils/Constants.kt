package com.chris.pokedex.utils

import java.io.Serializable

class Constants {

    object BundleKeys {
        const val GENERATION = "generation"
        const val POKEMON = "pokemon_id"
    }

    enum class Generation constructor(val id: Int) : Serializable {
        FIRST(1),
        SECOND(2),
        THIRD(3),
        FOURTH(4)
    }

    enum class Types constructor(val type: String) : Serializable {
        NORMAL("normal"),
        FIGHTING("fighting"),
        FLYING("flying"),
        POISON("poison"),
        GROUND("ground"),
        ROCK("rock"),
        BUG("bug"),
        GHOST("ghost"),
        STEEL("steel"),
        FIRE("fire"),
        WATER("water"),
        GRASS("grass"),
        ELECTRIC("electric"),
        PSYCHIC("psychic"),
        ICE("ice"),
        DRAGON("dragon"),
        DARK("dark"),
        FAIRY("fairy"),
        UNKNOWN("unknown"),
        SHADOW("shadow"),
    }

}