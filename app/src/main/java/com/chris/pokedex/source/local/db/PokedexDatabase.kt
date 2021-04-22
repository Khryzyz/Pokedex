package com.chris.pokedex.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chris.pokedex.source.local.dao.GenerationDao
import com.chris.pokedex.source.local.dao.PokemonDao
import com.chris.pokedex.source.local.entity.GenerationEntity
import com.chris.pokedex.source.local.entity.PokemonEntity

@Database(
    entities = [
        GenerationEntity::class,
        PokemonEntity::class
    ],
    version = 1
)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun generationDao(): GenerationDao

    abstract fun pokemonDao(): PokemonDao

}