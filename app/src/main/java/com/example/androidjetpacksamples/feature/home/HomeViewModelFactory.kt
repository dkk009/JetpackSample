package com.example.androidjetpacksamples.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.io.InvalidClassException
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val homeUseCase: HomeUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(homeUseCase = homeUseCase) as T
        } else {
            throw InvalidClassException("Class not found: $modelClass")
        }
    }

}