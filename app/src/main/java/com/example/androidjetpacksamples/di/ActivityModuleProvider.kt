package com.example.androidjetpacksamples.di

import com.example.androidjetpacksamples.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModuleProvider {

    @ContributesAndroidInjector()
    fun bindMainActivity(): MainActivity
}