package com.chris.pokedex.di.layer.ui

import com.chris.pokedex.layer.ui.dialog.move.MoveDialogFragment
import com.chris.pokedex.layer.ui.fragment.detail.DetailPokemonFragment
import com.chris.pokedex.layer.ui.fragment.info.InfoPokemonFragment
import com.chris.pokedex.layer.ui.fragment.list.ListPokemonFragment
import com.chris.pokedex.layer.ui.fragment.movements.MovementsPokemonFragment
import com.chris.pokedex.layer.ui.fragment.sprites.SpritesPokemonFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DialogBindingModule {

    @ContributesAndroidInjector
    abstract fun contributesMoveDialogFragment(): MoveDialogFragment

}