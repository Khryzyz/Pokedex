package com.chris.pokedex.di.ui

import com.chris.pokedex.ui.fragment.catched.CatchPokemonFragment
import com.chris.pokedex.ui.fragment.detail.DetailPokemonFragment
import com.chris.pokedex.ui.fragment.home.HomePokemonFragment
import com.chris.pokedex.ui.fragment.info.InfoPokemonFragment
import com.chris.pokedex.ui.fragment.movements.MovementsPokemonFragment
import com.chris.pokedex.ui.fragment.sprites.SpritesPokemonFragment
import com.chris.pokedex.ui.fragment.travel.TravelPokemonFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun contributesListPokemonFragment(): HomePokemonFragment

    @ContributesAndroidInjector
    abstract fun contributesDetailPokemonFragment(): DetailPokemonFragment

    @ContributesAndroidInjector
    abstract fun contributesInfoPokemonFragment(): InfoPokemonFragment

    @ContributesAndroidInjector
    abstract fun contributesMovementsPokemonFragment(): MovementsPokemonFragment

    @ContributesAndroidInjector
    abstract fun contributesSpritesPokemonFragment(): SpritesPokemonFragment

    @ContributesAndroidInjector
    abstract fun contributesTravelPokemonFragment(): TravelPokemonFragment

    @ContributesAndroidInjector
    abstract fun contributesCatchPokemonFragment(): CatchPokemonFragment

}