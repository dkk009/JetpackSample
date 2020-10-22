package com.example.androidjetpacksamples.feature.login

import androidx.lifecycle.LiveData
import com.example.androidjetpacksamples.room.entities.User

interface AuthRepository {

    fun login(user: User): LiveData<List<User>>
    suspend fun addUser(user: User):Long
}