package com.chris.pokedex.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chris.pokedex.source.local.DBConstants
import com.chris.pokedex.source.local.entity.GenerationEntity

@Dao
interface GenerationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGeneration(generationEntity: GenerationEntity): Long

}