package com.example.androidjetpacksamples.feature.home

import com.example.androidjetpacksamples.feature.home.model.Repo

interface HomeUseCase {
    suspend fun fetchPublicRepo(): List<Repo>
}