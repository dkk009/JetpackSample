package com.example.androidjetpacksamples.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidjetpacksamples.room.entities.User


@Dao
interface UserDao {
    @Query("SELECT * FROM USER")
    suspend fun getAll(): List<User>


    @Query("SELECT * FROM USER WHERE user_name LIKE :userName AND password LIKE :userPassword")
    fun getUser(userName: String, userPassword: String): LiveData<List<User>>

    @Insert
    suspend fun addUser(user: User): Long

    @Delete
    suspend fun deleteUser(user: User)
}