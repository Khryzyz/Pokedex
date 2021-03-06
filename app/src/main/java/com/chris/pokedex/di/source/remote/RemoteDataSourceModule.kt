package com.chris.pokedex.di.source.remote

import com.chris.pokedex.source.remote.dataSource.move.MoveRemoteDataSource
import com.chris.pokedex.source.remote.dataSource.move.MoveRemoteDataSourceImp
import com.chris.pokedex.source.remote.dataSource.pokemon.PokemonRemoteDataSource
import com.chris.pokedex.source.remote.dataSource.pokemon.PokemonRemoteDataSourceImp
import dagger.Binds
import dagger.Module

@Module
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindPokemonRemoteDataSource(dataSource: PokemonRemoteDataSourceImp): PokemonRemoteDataSource

    @Binds
    abstract fun bindMoveRemoteDataSource(dataSource: MoveRemoteDataSourceImp): MoveRemoteDataSource

}