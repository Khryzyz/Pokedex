package com.chris.pokedex.di.source.local

import com.chris.pokedex.source.local.dao.GenerationDao
import com.chris.pokedex.source.local.dao.PokemonDao
import com.chris.pokedex.source.local.db.PokedexDatabase
import dagger.Module
import dagger.Provides

@Module
class DaoModule {

    @Provides
    fun providesGenerationDao(database: PokedexDatabase): GenerationDao {
        return database.generationDao()
    }

    @Provides
    fun providesPokemonDao(database: PokedexDatabase): PokemonDao {
        return database.pokemonDao()
    }

}