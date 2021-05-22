package com.chris.pokedex.di.layer.ui

import com.chris.pokedex.layer.ui.dialog.move.MoveDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DialogBindingModule {

    @ContributesAndroidInjector
    abstract fun contributesMoveDialogFragment(): MoveDialogFragment

}