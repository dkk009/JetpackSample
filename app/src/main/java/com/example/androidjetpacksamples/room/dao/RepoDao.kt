package com.example.androidjetpacksamples.room.dao

import androidx.room.*
import com.example.androidjetpacksamples.feature.home.model.OwnerWithRepos
import com.example.androidjetpacksamples.feature.home.model.Repo
import com.example.androidjetpacksamples.feature.home.model.RepoWithOwner

@Dao
interface RepoDao {
    @Query("SELECT * FROM REPO")
    suspend fun getAll(): List<Repo>

    @Transaction
    @Query("SELECT * FROM REPO")
    suspend fun getRepoWithUser(): List<RepoWithOwner>

    @Transaction
    @Query("SELECT * FROM OWNER")
    suspend fun getUsersRepo(): List<OwnerWithRepos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repoList: List<Repo>)

    @Delete
    suspend fun delete(repo: Repo)

    @Update
    suspend fun updateRepo(repo: Repo)
}