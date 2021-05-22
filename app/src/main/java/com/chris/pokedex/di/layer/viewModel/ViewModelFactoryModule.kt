package com.chris.pokedex.di.layer.viewModel

import androidx.lifecycle.ViewModelProvider
import com.chris.pokedex.utils.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}