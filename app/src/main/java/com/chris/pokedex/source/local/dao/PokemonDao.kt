package com.chris.pokedex.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chris.pokedex.source.local.DBConstants
import com.chris.pokedex.source.local.entity.PokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPokemon(pokemonEntity: PokemonEntity): Long

    @Query("SELECT * FROM ${DBConstants.Pokemon.TABLE_NAME} WHERE ${DBConstants.Pokemon.COLUMN_GENERATION_ID} = :generationId ORDER BY ${DBConstants.Pokemon.COLUMN_ORDER} ASC")
    fun getListPokemonByGeneration(generationId: Long): List<PokemonEntity>

}