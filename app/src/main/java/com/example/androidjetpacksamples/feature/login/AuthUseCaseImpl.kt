package com.example.androidjetpacksamples.feature.login

import androidx.lifecycle.LiveData
import com.example.androidjetpacksamples.base.LoginResource
import com.example.androidjetpacksamples.room.entities.User
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository,
    private var dataMapper: AuthUiDataMapper
) : AuthUseCase {
    override fun isValidLoginData(loginUIData: LoginUIData): Boolean {
        return loginUIData.userName.isNullOrBlank().not() && loginUIData.password.isNullOrBlank()
            .not()
    }

    override fun login(loginUIData: LoginUIData): LiveData<List<User>> {
        return authRepository.login(dataMapper.getLoginData(loginUIData))
    }

    override fun getInitialLoginData(): LoginUIData {
        return dataMapper.getInitialLoginData()
    }

    override fun getLoginedUserData(user: List<User>): LoginResource {
        val currentUser = user.firstOrNull()
        return currentUser?.let {
            LoginResource.LoginStatus(true)
        } ?: LoginResource.LoginStatus(false)
    }

    override suspend fun addUser(user: User) {
        authRepository.addUser(user)
    }

}