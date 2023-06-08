package com.example.mybike.di

import android.content.Context
import com.example.mybike.data.database.AppDatabase
import com.example.mybike.data.local.dao.RideDAO
import com.example.mybike.data.repository.RideRepository
import com.example.mybike.data.repository.RideRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getAppDatabase(context)
    }

    @Singleton
    @Provides
    fun provideRideDAO(appDatabase: AppDatabase): RideDAO {
        return appDatabase.getRideDAO()
    }

    @Singleton
    @Provides
    fun provideRideRepository(rideDAO: RideDAO): RideRepository {
        return RideRepositoryImpl(rideDAO)
    }
}