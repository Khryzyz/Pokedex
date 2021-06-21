package com.chris.pokedex.source.remote.api

import com.chris.pokedex.source.remote.Api
import com.chris.pokedex.source.remote.ApiConstants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import junit.framework.TestCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

@RunWith(MockitoJUnitRunner::class)
class PokedexApiTest : TestCase() {

    private lateinit var mockWebServer: MockWebServer

    private lateinit var api: Api

    @Before
    override fun setUp() {

        MockitoAnnotations.initMocks(this)

        mockWebServer = MockWebServer()

        mockWebServer.start()

        val httpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        api = Retrofit
            .Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(Api::class.java)
    }

    @Test
    fun testGetListPokemon(){
        // Assign
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
//            .setBody()
        mockWebServer.enqueue(response)
//
//        var actualResponse
//
//        GlobalScope.launch {
//            actualResponse = api.getListPokemon(1)
//        }
//
//        // Assert
//        assertEquals(
//            response.toString().contains("200"),
//            actualResponse.code().toString().contains("200")
//        )

    }


}