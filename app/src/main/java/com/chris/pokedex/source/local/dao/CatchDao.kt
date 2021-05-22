package com.chris.pokedex.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chris.pokedex.source.local.DBConstants
import com.chris.pokedex.source.local.entity.CatchEntity

@Dao
interface CatchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCaughtPokemon(catchEntity: CatchEntity): Long

    @Query("SELECT * FROM ${DBConstants.Catch.TABLE_NAME} ORDER BY ${DBConstants.Catch.COLUMN_ID} DESC")
    fun getListPokemon(): List<CatchEntity>

}