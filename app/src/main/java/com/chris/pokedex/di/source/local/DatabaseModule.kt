package com.chris.pokedex.di.source.local

import android.content.Context
import androidx.room.Room
import com.chris.pokedex.source.local.db.PokedexDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(context: Context): PokedexDatabase {
        val db = Room.databaseBuilder(
            context,
            PokedexDatabase::class.java,
            "pokedex_database"
        )
        return db.build()
    }

}