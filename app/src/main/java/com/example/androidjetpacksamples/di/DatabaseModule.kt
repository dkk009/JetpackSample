package com.example.androidjetpacksamples.di

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.androidjetpacksamples.room.LocalDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

const val DATABASE_NAME = "localDatabase"

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(application: Application, migration: Migration): LocalDatabase {
        return Room.databaseBuilder(application, LocalDatabase::class.java, DATABASE_NAME)
            .addMigrations(migration).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideDBOneToDBTwoMigration(): Migration {
        val migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
        return migration
    }
}