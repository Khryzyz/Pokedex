package com.chris.pokedex.source.local.dataSource.catched

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.chris.pokedex.model.MoveBasicModel
import com.chris.pokedex.model.PokemonModel
import com.chris.pokedex.model.SpriteModel
import com.chris.pokedex.model.TypeModel
import com.chris.pokedex.source.local.dao.CatchDao
import com.chris.pokedex.source.local.db.PokedexDatabase
import com.chris.pokedex.utils.Constants
import com.chris.pokedex.utils.toCatchEntity
import junit.framework.TestCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Before
import org.junit.Test

class CatchLocalDataSourceImpTest : TestCase() {

    private lateinit var db: PokedexDatabase

    private lateinit var catchDao: CatchDao

    private lateinit var catchLocalDataSource: CatchLocalDataSourceImp

    private lateinit var pokemonModel: PokemonModel

    private lateinit var action: Constants.TravelAction

    @Before
    public override fun setUp() {

        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room
            .inMemoryDatabaseBuilder(
                context,
                PokedexDatabase::class.java
            )
            .build()

        catchDao = db.catchDao()

        catchLocalDataSource = CatchLocalDataSourceImp(catchDao)

        pokemonModel = PokemonModel(
            id = 1,
            webId = 1,
            name = "Poke",
            order = 151,
            height = 60,
            weight = 60,
            generationId = 1,
            moveBasics = listOf(
                MoveBasicModel(
                    id = 1,
                    "Move"
                )
            ),
            types = listOf(
                TypeModel(
                    typeName = Constants.Types.BUG,
                    typeImage = 0,
                    typeColor = 0,
                    typeIcon = 0
                )
            ),
            sprites = SpriteModel(
                officialArtwork = "",
                frontGenerationI = "",
                backGenerationI = "",
                frontGenerationII = "",
                backGenerationII = "",
                frontGenerationIII = "",
                backGenerationIII = "",
                frontGenerationIV = "",
                backGenerationIV = "",
            ),
        )

        action = Constants.TravelAction.CATCH
    }

    @After
    fun closeDB() {
        db.close()
    }

    @Test
    fun testInsertCaughtPokemon() {
        GlobalScope.launch {
            catchLocalDataSource.insertCaughtPokemon(pokemonModel, action)
        }
        val listPokemonCatch = catchDao.getListPokemon()
        assert(listPokemonCatch.contains(pokemonModel.toCatchEntity(action)))
    }

}