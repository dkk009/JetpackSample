package com.example.androidjetpacksamples.feature.login

import androidx.databinding.ObservableBoolean
import com.example.androidjetpacksamples.room.entities.User

class AuthUiDataMapper {

    fun getInitialLoginData(): LoginUIData {
        return LoginUIData(
            userName = "",
            password = "",
            enableLogin = ObservableBoolean(false)
        )
    }

    fun getLoginData(loginUIData: LoginUIData): User {
        return User(loginUIData.userName, loginUIData.password)
    }
}