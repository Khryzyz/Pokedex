package com.chris.pokedex.di.layer

import com.chris.pokedex.layer.ui.repository.ListPokemonRepository
import com.chris.pokedex.layer.ui.repository.ListPokemonRepositoryImp
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsListPokemon(repository: ListPokemonRepositoryImp): ListPokemonRepository


}