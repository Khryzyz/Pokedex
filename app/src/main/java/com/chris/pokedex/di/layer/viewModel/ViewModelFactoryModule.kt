package com.chris.pokedex.di.layer.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chris.pokedex.layer.ui.fragment.detail.DetailPokemonViewModel
import com.chris.pokedex.utils.viewModel.ViewModelFactory
import com.chris.pokedex.utils.viewModel.ViewModelKey
import com.chris.pokedex.layer.ui.fragment.list.ListPokemonViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}