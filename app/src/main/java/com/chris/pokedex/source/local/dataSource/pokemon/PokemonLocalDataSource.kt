package com.chris.pokedex.source.local.dataSource.pokemon

import com.chris.pokedex.source.local.entity.GenerationEntity
import com.chris.pokedex.source.local.entity.PokemonEntity
import com.chris.pokedex.utils.Constants

interface PokemonLocalDataSource {
    suspend fun insertGeneration(generationEntity: GenerationEntity): Long
    suspend fun insertPokemon(pokemonEntity: PokemonEntity): Long
    suspend fun getCountPokemonByGeneration(generationId: Constants.Generation): Int
    suspend fun getListPokemonByGeneration(generationId: Constants.Generation): List<PokemonEntity>
}