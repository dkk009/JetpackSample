package com.example.androidjetpacksamples.network

import com.example.androidjetpacksamples.feature.home.model.Repo
import retrofit2.http.GET

interface RemoteService {

    @GET("repositories")
    suspend fun getPublicRepos():List<Repo>
}