package com.chris.pokedex.repository.fragment.detail

import com.chris.pokedex.model.PokemonBasicModel
import com.chris.pokedex.source.remote.dataSource.pokemon.PokemonRemoteDataSource
import com.chris.pokedex.utils.uiState.UIStateDetailPokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailPokemonRepositoryImp
@Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource
) : DetailPokemonRepository {
    override fun getDetailPokemon(pokemonBasicModel: PokemonBasicModel): Flow<UIStateDetailPokemon> {
        return remoteDataSource.getDetailPokemon(pokemonBasicModel)
    }
}