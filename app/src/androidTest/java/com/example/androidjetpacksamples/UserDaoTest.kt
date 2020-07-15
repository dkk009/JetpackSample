package com.example.androidjetpacksamples

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidjetpacksamples.room.LocalDatabase
import com.example.androidjetpacksamples.room.entities.User
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var localDataBase: LocalDatabase
    private lateinit var USER: User

    @Before
    fun setUp() {
        localDataBase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            LocalDatabase::class.java
        ).allowMainThreadQueries().build()
        USER = User("user", "password")
    }

    @Test
    @kotlinx.coroutines.ExperimentalCoroutinesApi
    fun testInsertUser() = runBlockingTest {
        localDataBase.userDao().addUser(user = USER)
        val userList = localDataBase.userDao().getAll()
        Assert.assertEquals(
            localDataBase.userDao().getUser(userName = USER.userName, userPassword = USER.password)
                .getOrAwaitValue()[0].userName, USER.userName
        )
    }

    @After
    fun tear() {
        localDataBase.close()
    }
}