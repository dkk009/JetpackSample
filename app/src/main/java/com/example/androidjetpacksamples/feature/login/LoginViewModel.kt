package com.example.androidjetpacksamples.feature.login

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidjetpacksamples.base.BaseViewModel
import com.example.androidjetpacksamples.base.LoginResource
import com.example.androidjetpacksamples.room.entities.User
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : BaseViewModel(), LoginViewModelUseCase {
    private val _loginLiveData = MutableLiveData<LoginResource>()
    val showProgress = ObservableBoolean(false)
    val loginLiveData: LiveData<LoginResource>
        get() = _loginLiveData


    init {
        viewModelScope.launch {

        }
    }
    override fun getInitialLoginUiData(): LoginUIData {
        return authUseCase.getInitialLoginData()
    }

    override fun loginDataChange(loginUIData: LoginUIData) {
        Timber.d("LoginData:$loginUIData")
        loginUIData.apply {
            enableLogin.set(authUseCase.isValidLoginData(this))
        }
    }

    override fun handleLoginClick(loginUIData: LoginUIData) {
        if (authUseCase.isValidLoginData(loginUIData)) {
            viewModelScope.launch {
                authUseCase.login(loginUIData).observeForever {
                    _loginLiveData.value = authUseCase.getLoginedUserData(it)
                }
            }
        }
    }

    override fun addUser(loginUIData: LoginUIData) {
        viewModelScope.launch {
            loginUIData.enableLogin.set(false)
            Timber.d("Add User Method invoked")
            val time = System.currentTimeMillis()
            try {
                val id = authUseCase.addUser(User(loginUIData.userName, loginUIData.password))
                Timber.d("Add User Method duration:${System.currentTimeMillis() - time},:Id:$id")
                handleLoginClick(loginUIData)
                loginUIData.enableLogin.set(true)
            } catch ( e: Exception){
                Timber.d("Insert operation failed:$e")
            }

        }
    }
}