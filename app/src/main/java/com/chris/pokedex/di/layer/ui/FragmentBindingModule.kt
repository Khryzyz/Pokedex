package com.chris.pokedex.di.layer.ui

import com.chris.pokedex.layer.ui.fragment.detail.DetailPokemonFragment
import com.chris.pokedex.layer.ui.fragment.list.ListPokemonFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun contributesListPokemonFragment(): ListPokemonFragment

    @ContributesAndroidInjector
    abstract fun contributesDetailPokemonFragment(): DetailPokemonFragment

}