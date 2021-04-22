package com.chris.pokedex.source.local

object DBConstants {
    object Generation {
        const val TABLE_NAME = "generation"
        const val COLUMN_ID = "id"
        const val COLUMN_WEB_ID = "web_id"
        const val COLUMN_NAME = "name"
    }

    object Pokemon {
        const val TABLE_NAME = "pokemon"
        const val COLUMN_ID = "id"
        const val COLUMN_WEB_ID = "web_id"
        const val COLUMN_NAME = "name"
        const val COLUMN_ORDER = "numberOrder"
        const val COLUMN_HEIGHT = "height"
        const val COLUMN_WEIGHT = "weight"
        const val COLUMN_GENERATION_TYPE_A = "type_a"
        const val COLUMN_GENERATION_TYPE_B = "type_b"
        const val COLUMN_GENERATION_ID = "generation_id"
    }
}