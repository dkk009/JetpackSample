package com.example.androidjetpacksamples.di

import com.example.androidjetpacksamples.app.PreferenceManager
import com.example.androidjetpacksamples.feature.login.*
import com.example.androidjetpacksamples.network.RemoteService
import com.example.androidjetpacksamples.room.LocalDatabase
import dagger.Module
import dagger.Provides

@Module
class LoginFragmentModule {
    @Provides
    fun provideAuthRepository(
        localDatabase: LocalDatabase,
        remoteService: RemoteService,
        preferenceManager: PreferenceManager
    ): AuthRepository {
        return AuthRepositoryImpl(
            localDatabase,
            remoteService,
            preferenceManager
        )
    }

    @Provides
    fun provideAuthUseCase(
        authRepository: AuthRepository,
        authUiDataMapper: AuthUiDataMapper
    ): AuthUseCase {
        return AuthUseCaseImpl(authRepository = authRepository, dataMapper = authUiDataMapper)
    }

    @Provides
    fun provideLoginDataMapper(): AuthUiDataMapper {
        return AuthUiDataMapper()
    }

}