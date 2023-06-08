package com.example.mybike.di

import com.example.mybike.BikeApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivitiesModule::class
    ]
)

@Singleton
interface AppComponent {
    fun inject(application: BikeApp)
}