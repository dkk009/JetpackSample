package com.example.androidjetpacksamples.di

import android.app.Application
import com.example.androidjetpacksamples.app.JetpackApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    dependencies = [],
    modules = [NetWorkModule::class, DatabaseModule::class, AppModule::class, FragmentProvider::class,
        AndroidSupportInjectionModule::class, AndroidInjectionModule::class, ActivityModuleProvider::class]
)
@Singleton
interface AppComponent : AndroidInjector<JetpackApp> {
    fun injectApp(app: JetpackApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(app: Application): Builder
        fun build(): AppComponent
    }

}