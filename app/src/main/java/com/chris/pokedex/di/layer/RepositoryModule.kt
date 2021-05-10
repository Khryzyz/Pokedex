package com.chris.pokedex.di.layer

import com.chris.pokedex.layer.repository.detail.DetailPokemonRepository
import com.chris.pokedex.layer.repository.detail.DetailPokemonRepositoryImp
import com.chris.pokedex.layer.repository.list.ListPokemonRepository
import com.chris.pokedex.layer.repository.list.ListPokemonRepositoryImp
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsListPokemon(repository: ListPokemonRepositoryImp): ListPokemonRepository

    @Binds
    abstract fun bindsDetailPokemon(repository: DetailPokemonRepositoryImp): DetailPokemonRepository

}