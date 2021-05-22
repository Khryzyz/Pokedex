package com.chris.pokedex.di.source.local

import com.chris.pokedex.source.local.dao.CatchDao
import com.chris.pokedex.source.local.db.PokedexDatabase
import dagger.Module
import dagger.Provides

@Module
class DaoModule {

    @Provides
    fun providesPokemonDao(database: PokedexDatabase): CatchDao {
        return database.catchedDao()
    }

}