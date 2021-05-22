package com.chris.pokedex.di.source.local

import com.chris.pokedex.source.local.dataSource.vote.CatchLocalDataSource
import com.chris.pokedex.source.local.dataSource.vote.CatchLocalDataSourceImp
import dagger.Binds
import dagger.Module

@Module
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindVoteLocalDataSource(dataSource: CatchLocalDataSourceImp): CatchLocalDataSource

}