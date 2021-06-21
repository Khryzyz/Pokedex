package com.chris.pokedex.source.local.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.chris.pokedex.source.local.dao.CatchDao
import com.chris.pokedex.source.local.entity.CatchEntity
import com.chris.pokedex.utils.Constants
import junit.framework.TestCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Before
import org.junit.Test

class PokedexDatabaseTest : TestCase() {

    private lateinit var db: PokedexDatabase
    private lateinit var catchDao: CatchDao
    private lateinit var catchEntity: CatchEntity
    private lateinit var listCatchEntity: List<CatchEntity>

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

        catchEntity = CatchEntity(
            id = 0,
            webId = 1,
            name = "Poke",
            action = Constants.TravelAction.CATCH.action
        )

        listCatchEntity = listOf(
            CatchEntity(
                id = 0,
                webId = 2,
                name = "Poke",
                action = Constants.TravelAction.CATCH.action
            ),
            CatchEntity(
                id = 0,
                webId = 3,
                name = "Poke",
                action = Constants.TravelAction.CATCH.action
            ),
            CatchEntity(
                id = 0,
                webId = 4,
                name = "Poke",
                action = Constants.TravelAction.CATCH.action
            )
        )

    }

    @After
    fun closeDB() {
        db.close()
    }

    @Test
    fun testInsertCaughtPokemon() {
        var idGenerated: Long = -1
        GlobalScope.launch {
            idGenerated = catchDao.insertCaughtPokemon(catchEntity)
        }
        assert(idGenerated != -1L)
    }

    @Test
    fun testGetListPokemon() {
        listCatchEntity.forEach {
            GlobalScope.launch {
                catchDao.insertCaughtPokemon(it)
            }
        }
        val listCatch = catchDao.getListPokemon()
        assert(listCatch.containsAll(listCatchEntity))
    }
}