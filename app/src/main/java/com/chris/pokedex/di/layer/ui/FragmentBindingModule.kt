package com.chris.pokedex.di.layer.ui

import com.chris.pokedex.layer.ui.fragment.detail.DetailPokemonFragment
import com.chris.pokedex.layer.ui.fragment.info.InfoPokemonFragment
import com.chris.pokedex.layer.ui.fragment.list.ListPokemonFragment
import com.chris.pokedex.layer.ui.fragment.movements.MovementsPokemonFragment
import com.chris.pokedex.layer.ui.fragment.sprites.SpritesPokemonFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun contributesListPokemonFragment(): ListPokemonFragment

    @ContributesAndroidInjector
    abstract fun contributesDetailPokemonFragment(): DetailPokemonFragment

    @ContributesAndroidInjector
    abstract fun contributesInfoPokemonFragment(): InfoPokemonFragment

    @ContributesAndroidInjector
    abstract fun contributesMovementsPokemonFragment(): MovementsPokemonFragment

    @ContributesAndroidInjector
    abstract fun contributesSpritesPokemonFragment(): SpritesPokemonFragment

}