package com.example.androidjetpacksamples.feature.login

import com.example.androidjetpacksamples.app.PreferenceManager
import com.example.androidjetpacksamples.base.BaseRepository
import com.example.androidjetpacksamples.network.RemoteService
import com.example.androidjetpacksamples.room.LocalDatabase
import com.example.androidjetpacksamples.room.entities.User
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val localDatabase: LocalDatabase,
    private val remoteService: RemoteService,
    private val preferenceManager: PreferenceManager
) : BaseRepository(localDatabase, remoteService, preferenceManager), AuthRepository {
    override fun login(user: User) =
        localDatabase.userDao().getUser(userName = user.userName, userPassword = user.password)

    override suspend fun addUser(user: User) = localDatabase.userDao().addUser(user)

}