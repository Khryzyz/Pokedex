package com.chris.pokedex.di.source

import com.chris.pokedex.source.local.dataSource.pokemon.PokemonLocalDataSource
import com.chris.pokedex.source.local.dataSource.pokemon.PokemonLocalDataSourceImp
import dagger.Binds
import dagger.Module

@Module
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindPokemonLocalDataSource(dataSource: PokemonLocalDataSourceImp): PokemonLocalDataSource

}