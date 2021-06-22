package com.chris.pokedex.di.viewModel

import androidx.lifecycle.ViewModel
import com.chris.pokedex.ui.dialog.move.MoveViewModel
import com.chris.pokedex.utils.viewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DialogViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MoveViewModel::class)
    internal abstract fun bindsMoveViewModel(viewModel: MoveViewModel): ViewModel

}