package com.chris.pokedex.source.local.dataSource.pokemon

import com.chris.pokedex.source.local.dao.GenerationDao
import com.chris.pokedex.source.local.dao.PokemonDao
import com.chris.pokedex.source.local.entity.GenerationEntity
import com.chris.pokedex.source.local.entity.PokemonEntity
import com.chris.pokedex.utils.Constants
import javax.inject.Inject

class PokemonLocalDataSourceImp
@Inject constructor(
    private val generationDao: GenerationDao,
    private val pokemonDao: PokemonDao
) : PokemonLocalDataSource {
    override suspend fun insertGeneration(generationEntity: GenerationEntity): Long {
        return generationDao.insertGeneration(generationEntity)
    }

    override suspend fun insertPokemon(pokemonEntity: PokemonEntity): Long {
        return pokemonDao.insertPokemon(pokemonEntity)
    }

    override suspend fun getCountPokemonByGeneration(generationId: Constants.Generation): Int {
        return pokemonDao.getListPokemonByGeneration(generationId.id.toLong()).size
    }

    override suspend fun getListPokemonByGeneration(generationId: Constants.Generation): List<PokemonEntity> {
        return pokemonDao.getListPokemonByGeneration(generationId.id.toLong())
    }
}