package com.example.androidjetpacksamples.feature.login

interface LoginViewModelUseCase {
    fun getInitialLoginUiData(): LoginUIData
    fun loginDataChange(loginUIData: LoginUIData)
    fun handleLoginClick(loginUIData: LoginUIData)
    fun addUser(loginUIData: LoginUIData)
}