package com.example.androidjetpacksamples.feature.login

import androidx.databinding.ObservableBoolean

data class LoginUIData(
    var userName: String,
    var password: String,
    var enableLogin: ObservableBoolean
)