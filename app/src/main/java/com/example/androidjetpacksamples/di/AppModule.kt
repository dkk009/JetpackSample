package com.example.androidjetpacksamples.di

import android.app.Application
import android.content.Context
import com.example.androidjetpacksamples.app.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {


    @Singleton
    @Provides
    fun providePreferenceManager(context: Context): PreferenceManager {
        return PreferenceManager(context)
    }

    @Provides
    @Singleton
    fun provideAppContext(application: Application): Context {
        return application.applicationContext
    }

}