package com.chris.pokedex.layer.repository.detail

import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.source.local.dataSource.pokemon.PokemonLocalDataSource
import com.chris.pokedex.source.remote.dataSource.pokemon.PokemonRemoteDataSource
import com.chris.pokedex.utils.uiState.UIState
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailPokemonRepositoryImp @Inject constructor(
    private val localDataSource: PokemonLocalDataSource,
    private val remoteDataSource: PokemonRemoteDataSource
) : DetailPokemonRepository {
    override suspend fun getDetailPokemon(pokemonBasicModel: PokemonBasicModel): Flow<UIStateDetailPokemon> {
        return remoteDataSource.getDetailPokemon(pokemonBasicModel)
    }
}