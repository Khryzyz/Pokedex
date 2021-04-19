package com.chris.pokedex.di

import android.app.Application
import com.chris.pokedex.app.PokedexApplication
import com.chris.pokedex.di.layer.RepositoryModule
import com.chris.pokedex.di.layer.ui.ActivityBindingModule
import com.chris.pokedex.di.layer.ui.FragmentBindingModule
import com.chris.pokedex.di.layer.ui.ViewModelModule
import com.chris.pokedex.di.source.local.LocalDataSourceModule
import com.chris.pokedex.di.source.remote.MoshiModule
import com.chris.pokedex.di.source.remote.RemoteDataSourceModule
import com.chris.pokedex.di.source.remote.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        //General
        AndroidInjectionModule::class,

        //Layer
        ActivityBindingModule::class,
        FragmentBindingModule::class,
        ViewModelModule::class,
        RepositoryModule::class,

        //Source Local
        LocalDataSourceModule::class,

        //Source Remote
        RetrofitModule::class,
        MoshiModule::class,
        RemoteDataSourceModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<PokedexApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun create(application: Application): Builder

        fun build(): ApplicationComponent

    }

}