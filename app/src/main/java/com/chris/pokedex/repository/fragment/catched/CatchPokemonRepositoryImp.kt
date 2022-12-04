package com.chris.pokedex.repository.fragment.catched

import com.chris.pokedex.source.local.dataSource.catched.CatchLocalDataSource
import com.chris.pokedex.utils.uiState.UIStateListPokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatchPokemonRepositoryImp
@Inject constructor(
    private val localDataSource: CatchLocalDataSource
) : CatchPokemonRepository {
    override fun getListPokemon(): Flow<UIStateListPokemon> {
        return localDataSource.getListPokemon()
    }

}