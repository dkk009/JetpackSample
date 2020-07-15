package com.example.androidjetpacksamples.feature.home

import com.example.androidjetpacksamples.feature.home.model.Repo

class HomeUseImpl(
    private val homeRepository: HomeRepository,
    private val homeDataUiMapper: HomeDataUiMapper
) : HomeUseCase {
    override suspend fun fetchPublicRepo(): List<Repo> {
        return homeRepository.fetchPublicRepos()
    }

}