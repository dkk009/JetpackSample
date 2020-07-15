package com.example.androidjetpacksamples.base

import com.example.androidjetpacksamples.app.PreferenceManager
import com.example.androidjetpacksamples.network.RemoteService
import com.example.androidjetpacksamples.room.LocalDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

abstract class BaseRepository(
    localDatabase: LocalDatabase,
    remoteService: RemoteService,
    preferenceManager: PreferenceManager
) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}