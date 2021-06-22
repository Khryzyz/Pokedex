package com.chris.pokedex.di

import android.app.Application
import com.chris.pokedex.app.PokedexApplication
import com.chris.pokedex.di.core.ApplicationModule
import com.chris.pokedex.di.repository.DialogRepositoryModule
import com.chris.pokedex.di.repository.FragmentRepositoryModule
import com.chris.pokedex.di.ui.ActivityBindingModule
import com.chris.pokedex.di.ui.DialogBindingModule
import com.chris.pokedex.di.ui.FragmentBindingModule
import com.chris.pokedex.di.viewModel.DialogViewModelModule
import com.chris.pokedex.di.viewModel.FragmentViewModelModule
import com.chris.pokedex.di.viewModel.ViewModelFactoryModule
import com.chris.pokedex.di.source.local.DaoModule
import com.chris.pokedex.di.source.local.DatabaseModule
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
        ApplicationModule::class,

        //Layer.UI
        ActivityBindingModule::class,
        FragmentBindingModule::class,
        DialogBindingModule::class,
        //Layer.ViewModel
        ViewModelFactoryModule::class,
        FragmentViewModelModule::class,
        DialogViewModelModule::class,
        //Layer.Repository
        FragmentRepositoryModule::class,
        DialogRepositoryModule::class,

        //Source Local
        DatabaseModule::class,
        DaoModule::class,
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