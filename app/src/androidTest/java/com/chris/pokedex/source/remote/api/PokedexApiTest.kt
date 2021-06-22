package com.chris.pokedex.source.remote.api

import junit.framework.TestCase

class PokedexApiTest : TestCase() {
//
//    private lateinit var mockWebServer: MockWebServer
//
//    private lateinit var api: Api
//
//    private lateinit var actualResponse: Response<GenerationResDTO>
//
//    @Before
//    override fun setUp() {
//
//        MockitoAnnotations.initMocks(this)
//
//        mockWebServer = MockWebServer()
//
//        mockWebServer.start()
//
//        val httpClient = OkHttpClient.Builder()
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .build()
//
//        val moshi = Moshi.Builder()
//            .add(KotlinJsonAdapterFactory())
//            .build()
//
//        api = Retrofit
//            .Builder()
//            .baseUrl(ApiConstants.BASE_URL)
//            .client(httpClient)
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .build()
//            .create(Api::class.java)
//    }
//
//    @Test
//    fun testGetListPokemon() {
//        val response = MockResponse()
//            .setResponseCode(HttpURLConnection.HTTP_OK)
//
//        mockWebServer.enqueue(response)
//
//        GlobalScope.launch {
//            actualResponse = api.getListPokemon(1)
//        }
//
//        assertEquals(
//            response.toString().contains("200"),
//            actualResponse.code().toString().contains("200")
//        )
//    }

}