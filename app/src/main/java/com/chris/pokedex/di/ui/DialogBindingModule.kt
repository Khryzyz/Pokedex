package com.chris.pokedex.di.ui

import com.chris.pokedex.ui.dialog.move.MoveDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DialogBindingModule {

    @ContributesAndroidInjector
    abstract fun contributesMoveDialogFragment(): MoveDialogFragment

}