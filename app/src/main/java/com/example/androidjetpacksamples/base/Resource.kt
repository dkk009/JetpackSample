package com.example.androidjetpacksamples.base

sealed class LoginResource {
    data class LoginStatus(val isLogin: Boolean):LoginResource()
    data class Error(val exception: Exception, val message: String, val errorCode: Int = 0):LoginResource()
}