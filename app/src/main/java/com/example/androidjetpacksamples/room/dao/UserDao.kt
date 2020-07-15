package com.example.androidjetpacksamples.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.androidjetpacksamples.room.entities.User


@Dao
interface UserDao {
    @Query("SELECT * FROM USER")
    suspend fun getAll(): List<User>


    @Query("SELECT * FROM USER WHERE user_name LIKE :userName AND password LIKE :userPassword")
    fun getUser(userName: String, userPassword: String): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}