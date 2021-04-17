package com.chris.pokedex.app

import com.chris.pokedex.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class PokedexApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder()
            .create(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}