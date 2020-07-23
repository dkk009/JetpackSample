package com.example.androidjetpacksamples.di

import com.example.androidjetpacksamples.network.RemoteService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetWorkModule {
    private val baseUrl = "https://api.github.com/"

    @Singleton
    @Provides
    fun provideRemoteService(okHttpClient: OkHttpClient): RemoteService {
        return Retrofit.Builder().baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RemoteService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Singleton
    @Provides
    fun provideDebugBuilder(): Interceptor {
        val httpLoginInterceptor = HttpLoggingInterceptor()
        httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoginInterceptor
    }
}
