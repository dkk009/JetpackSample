package com.example.androidjetpacksamples.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class LoginViewModelFactory @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val authUiDataMapper: AuthUiDataMapper
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(
                authUseCase = authUseCase
            ) as T
        } else {
            throw IllegalArgumentException("View model not found")
        }
    }

}