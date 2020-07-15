package com.example.androidjetpacksamples.feature

import com.example.androidjetpacksamples.feature.home.model.Owner
import com.example.androidjetpacksamples.feature.home.model.Repo
import com.example.androidjetpacksamples.network.RemoteService
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit

class APITest {
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var remoteService: RemoteService

    @Before
    fun setUp() {

    }

    @Test
    @kotlinx.coroutines.ExperimentalCoroutinesApi
    fun testPublicRepo() = runBlockingTest {
        Mockito.`when`(remoteService.getPublicRepos()).thenReturn(getDummyRepo())
        Assert.assertNotNull(remoteService.getPublicRepos())
    }

    private fun getDummyRepo(): List<Repo>? {
        val lits = mutableListOf<Repo>()
        val owner = Owner("login", 1, "avatar", "followUrl")
        lits.add(Repo(1, "Name", "FullName", "Url", owner))
        return lits

    }
}