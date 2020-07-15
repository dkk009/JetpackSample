package com.example.androidjetpacksamples.di

import com.example.androidjetpacksamples.app.PreferenceManager
import com.example.androidjetpacksamples.feature.home.*
import com.example.androidjetpacksamples.network.RemoteService
import com.example.androidjetpacksamples.room.LocalDatabase
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    fun provideHomRepository(
        localDatabase: LocalDatabase,
        remoteService: RemoteService,
        preferenceManager: PreferenceManager
    ): HomeRepository {
        return HomeRepositoryImpl(
            remoteService = remoteService,
            localDatabase = localDatabase,
            preferenceManager = preferenceManager
        )
    }

    @Provides
    fun provideHomeUseCase(
        homeRepository: HomeRepository,
        homeDataUiMapper: HomeDataUiMapper
    ): HomeUseCase {
        return HomeUseImpl(homeRepository = homeRepository, homeDataUiMapper = homeDataUiMapper)
    }

    @Provides
    fun provideHomeDataUiMapper(): HomeDataUiMapper {
        return HomeDataUiMapper()
    }
}