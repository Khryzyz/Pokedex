package com.chris.pokedex.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chris.pokedex.source.local.dao.CatchDao
import com.chris.pokedex.source.local.entity.CatchEntity

@Database(
    entities = [
        CatchEntity::class
    ],
    version = 1
)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun catchedDao(): CatchDao

}