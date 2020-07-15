package com.example.androidjetpacksamples.di

import com.example.androidjetpacksamples.feature.SplashFragment
import com.example.androidjetpacksamples.feature.home.HomeFragment
import com.example.androidjetpacksamples.feature.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {
    @ContributesAndroidInjector()
    abstract fun provideSplashFragment(): SplashFragment

    @ContributesAndroidInjector(modules = [LoginFragmentModule::class, ViewModelModule::class])
    abstract fun provideLoginFragment(): LoginFragment

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class, ViewModelModule::class])
    abstract fun provideHomeFragment(): HomeFragment
}