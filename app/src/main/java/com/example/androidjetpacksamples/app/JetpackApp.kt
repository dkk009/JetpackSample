package com.example.androidjetpacksamples.app

import com.example.androidjetpacksamples.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class JetpackApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().bindApplication(this).build()
        appComponent.injectApp(this)
        return appComponent
    }
}