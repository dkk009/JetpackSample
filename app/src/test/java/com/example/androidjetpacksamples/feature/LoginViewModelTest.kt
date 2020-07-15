package com.example.androidjetpacksamples.feature

import com.example.androidjetpacksamples.feature.login.AuthRepository
import com.example.androidjetpacksamples.feature.login.AuthUiDataMapper
import com.example.androidjetpacksamples.feature.login.AuthUseCaseImpl
import com.example.androidjetpacksamples.feature.login.LoginViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

class LoginViewModelTest {
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    lateinit var authUseCase: AuthUseCaseImpl
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var authUiDataMapper: AuthUiDataMapper
    @Mock
    lateinit var authRepository: AuthRepository
    @Before
    fun setUp() {
        authUiDataMapper = AuthUiDataMapper()
        authUseCase = AuthUseCaseImpl(authRepository,authUiDataMapper)
        loginViewModel =
            LoginViewModel(authUseCase)
    }

    @Test
    fun testTesLoginInitialData() {
        loginViewModel.getInitialLoginUiData().apply {
            Assert.assertFalse(enableLogin.get())
        }
    }

    @Test
    fun testLoginDataChangeWithValidData() {
        val loginUiData = authUiDataMapper.getInitialLoginData()
        loginUiData.userName = "UserName"
        loginUiData.password = "Password"
        loginViewModel.loginDataChange(loginUiData)
        assert(loginUiData.enableLogin.get())
    }


    @Test
    fun testLoginDataChangeWithOneValidData() {
        val loginUiData = authUiDataMapper.getInitialLoginData()
        loginUiData.userName = "UserName"
        loginUiData.password = ""
        loginViewModel.loginDataChange(loginUiData)
        Assert.assertFalse(loginUiData.enableLogin.get())
    }
}