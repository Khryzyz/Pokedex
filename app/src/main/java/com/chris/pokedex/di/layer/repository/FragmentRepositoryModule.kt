package com.chris.pokedex.di.layer.repository

import com.chris.pokedex.layer.repository.fragment.detail.DetailPokemonRepository
import com.chris.pokedex.layer.repository.fragment.detail.DetailPokemonRepositoryImp
import com.chris.pokedex.layer.repository.fragment.list.ListPokemonRepository
import com.chris.pokedex.layer.repository.fragment.list.ListPokemonRepositoryImp
import com.chris.pokedex.layer.repository.fragment.catchRepository.CatchPokemonRepository
import com.chris.pokedex.layer.repository.fragment.catchRepository.CatchPokemonRepositoryImp
import dagger.Binds
import dagger.Module

@Module
abstract class FragmentRepositoryModule {

    @Binds
    abstract fun bindsListPokemonRepository(repository: ListPokemonRepositoryImp): ListPokemonRepository

    @Binds
    abstract fun bindsDetailPokemonRepository(repository: DetailPokemonRepositoryImp): DetailPokemonRepository

    @Binds
    abstract fun bindsVotePokemonRepository(repository: CatchPokemonRepositoryImp): CatchPokemonRepository

}