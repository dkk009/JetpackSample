package com.example.androidjetpacksamples.feature.home

interface HomeViewModelUseCase {
    fun fetchPublicRepo()
    fun fetchRepoDetails(repoId:Long)
}