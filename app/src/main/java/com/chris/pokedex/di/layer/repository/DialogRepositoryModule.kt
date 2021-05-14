package com.chris.pokedex.di.layer.repository

import com.chris.pokedex.layer.repository.dialog.move.MoveRepository
import com.chris.pokedex.layer.repository.dialog.move.MoveRepositoryImp
import com.chris.pokedex.layer.repository.fragment.detail.DetailPokemonRepository
import com.chris.pokedex.layer.repository.fragment.detail.DetailPokemonRepositoryImp
import com.chris.pokedex.layer.repository.fragment.list.ListPokemonRepository
import com.chris.pokedex.layer.repository.fragment.list.ListPokemonRepositoryImp
import dagger.Binds
import dagger.Module

@Module
abstract class DialogRepositoryModule {

    @Binds
    abstract fun bindsMoveRepository(repository: MoveRepositoryImp): MoveRepository

}