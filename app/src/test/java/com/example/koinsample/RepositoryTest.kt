package com.example.koinsample

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.get

class ExampleUnitTest : KoinTest {

    // There are several ways to use Koin in tests. One of them is to init "real", "full" injector
    // and override only some of dependencies

    @Before
    fun setUp() {

        initInjector()

        val testModule = module(override = true) {
            single<WebService> { TestWebService() }
        }

        loadKoinModules(testModule)
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun exampleTest() {
        val repository = get<Repository>()
        assertEquals("TEST TEXT", repository.getText())
    }

    class TestWebService : WebService {
        override fun loadData(): String = "TEST TEXT"
    }
}
