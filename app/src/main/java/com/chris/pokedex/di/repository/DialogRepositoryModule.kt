package com.chris.pokedex.di.repository

import com.chris.pokedex.repository.dialog.move.MoveRepository
import com.chris.pokedex.repository.dialog.move.MoveRepositoryImp
import dagger.Binds
import dagger.Module

@Module
abstract class DialogRepositoryModule {

    @Binds
    abstract fun bindsMoveRepository(repository: MoveRepositoryImp): MoveRepository

}