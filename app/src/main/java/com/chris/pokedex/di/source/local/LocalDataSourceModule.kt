package com.chris.pokedex.di.source.local

import com.chris.pokedex.source.local.dataSource.catched.CatchLocalDataSource
import com.chris.pokedex.source.local.dataSource.catched.CatchLocalDataSourceImp
import dagger.Binds
import dagger.Module

@Module
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindCatchLocalDataSource(dataSource: CatchLocalDataSourceImp): CatchLocalDataSource

}