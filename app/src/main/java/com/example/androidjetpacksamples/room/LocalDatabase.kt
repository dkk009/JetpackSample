package com.example.androidjetpacksamples.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidjetpacksamples.feature.home.model.Owner
import com.example.androidjetpacksamples.feature.home.model.Repo
import com.example.androidjetpacksamples.feature.home.model.RepoOwnerCrossRef
import com.example.androidjetpacksamples.room.dao.RepoDao
import com.example.androidjetpacksamples.room.dao.UserDao
import com.example.androidjetpacksamples.room.entities.User

const val DATABASE_VERSION = 2

@Database(
    entities = [User::class, Repo::class, Owner::class, RepoOwnerCrossRef::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun repoDao(): RepoDao
}