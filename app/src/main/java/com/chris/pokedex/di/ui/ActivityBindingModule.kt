package com.chris.pokedex.di.ui

import com.chris.pokedex.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

}