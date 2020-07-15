package com.example.androidjetpacksamples.feature.home

import com.example.androidjetpacksamples.app.PreferenceManager
import com.example.androidjetpacksamples.base.BaseRepository
import com.example.androidjetpacksamples.feature.home.model.Repo
import com.example.androidjetpacksamples.network.RemoteService
import com.example.androidjetpacksamples.room.LocalDatabase
import kotlinx.coroutines.delay
import retrofit2.HttpException
import timber.log.Timber

interface HomeRepository {
    suspend fun fetchPublicRepos(): List<Repo>
}

class HomeRepositoryImpl(
    private val remoteService: RemoteService,
    private val localDatabase: LocalDatabase,
    private val preferenceManager: PreferenceManager
) :
    HomeRepository, BaseRepository(localDatabase, remoteService, preferenceManager) {
    override suspend fun fetchPublicRepos(): List<Repo> {
        var repolist = emptyList<Repo>()
        try {
            delay(3000L)
            repolist = remoteService.getPublicRepos()
            localDatabase.repoDao().insertAll(repolist)
        } catch (exc: HttpException) {
            repolist = localDatabase.repoDao().getAll()
        }
        Timber.d("Repo Size:${repolist.size}")
        return repolist
    }

}