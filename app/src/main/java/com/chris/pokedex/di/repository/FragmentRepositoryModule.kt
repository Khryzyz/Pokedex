package com.chris.pokedex.di.repository

import com.chris.pokedex.repository.fragment.catched.CatchPokemonRepository
import com.chris.pokedex.repository.fragment.catched.CatchPokemonRepositoryImp
import com.chris.pokedex.repository.fragment.detail.DetailPokemonRepository
import com.chris.pokedex.repository.fragment.detail.DetailPokemonRepositoryImp
import com.chris.pokedex.repository.fragment.list.ListPokemonRepository
import com.chris.pokedex.repository.fragment.list.ListPokemonRepositoryImp
import com.chris.pokedex.repository.fragment.travel.TravelPokemonRepository
import com.chris.pokedex.repository.fragment.travel.TravelPokemonRepositoryImp
import dagger.Binds
import dagger.Module

@Module
abstract class FragmentRepositoryModule {

    @Binds
    abstract fun bindsListPokemonRepository(repository: ListPokemonRepositoryImp): ListPokemonRepository

    @Binds
    abstract fun bindsDetailPokemonRepository(repository: DetailPokemonRepositoryImp): DetailPokemonRepository

    @Binds
    abstract fun bindsTravelPokemonRepository(repository: TravelPokemonRepositoryImp): TravelPokemonRepository

    @Binds
    abstract fun bindsCatchPokemonRepository(repository: CatchPokemonRepositoryImp): CatchPokemonRepository

}