package com.chris.pokedex.di.layer.ui

import com.chris.pokedex.layer.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

}