package com.chris.pokedex.layer.repository.fragment.detail

import com.chris.pokedex.layer.model.PokemonBasicModel
import com.chris.pokedex.source.remote.dataSource.pokemon.PokemonRemoteDataSource
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailPokemonRepositoryImp @Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource
) : DetailPokemonRepository {
    override suspend fun getDetailPokemon(pokemonBasicModel: PokemonBasicModel): Flow<UIStateDetailPokemon> {
        return remoteDataSource.getDetailPokemon(pokemonBasicModel)
    }

    override suspend fun getDetailPokemon(pokemonId: Int): Flow<UIStateDetailPokemon> {
        return remoteDataSource.getDetailPokemon(pokemonId)
    }

    override suspend fun getDetailPokemon(listPokemonId: List<Int>): Flow<UIStateDetailPokemon> {
        return remoteDataSource.getDetailPokemon(listPokemonId)
    }
}