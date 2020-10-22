package com.example.androidjetpacksamples.feature.login

import androidx.lifecycle.LiveData
import com.example.androidjetpacksamples.base.LoginResource
import com.example.androidjetpacksamples.room.entities.User

interface AuthUseCase {

    fun isValidLoginData(loginUIData: LoginUIData): Boolean
    fun login(loginUIData: LoginUIData): LiveData<List<User>>
    fun getInitialLoginData(): LoginUIData
    fun getLoginedUserData(user: List<User>): LoginResource
    suspend fun addUser(user: User): Long
}