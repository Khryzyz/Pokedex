package com.chris.pokedex.di.layer.viewModel

import androidx.lifecycle.ViewModel
import com.chris.pokedex.layer.ui.fragment.catched.CatchPokemonViewModel
import com.chris.pokedex.layer.ui.fragment.detail.DetailPokemonViewModel
import com.chris.pokedex.layer.ui.fragment.home.HomePokemonViewModel
import com.chris.pokedex.layer.ui.fragment.travel.TravelPokemonViewModel
import com.chris.pokedex.utils.viewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomePokemonViewModel::class)
    internal abstract fun bindsListPokemonViewModel(viewModel: HomePokemonViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailPokemonViewModel::class)
    internal abstract fun bindsDetailPokemonViewModel(viewModel: DetailPokemonViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TravelPokemonViewModel::class)
    internal abstract fun bindsTravelPokemonViewModel(viewModel: TravelPokemonViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CatchPokemonViewModel::class)
    internal abstract fun bindsCatchPokemonViewModel(viewModel: CatchPokemonViewModel): ViewModel

}