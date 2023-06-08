package com.example.mybike.di

import android.content.Context
import com.example.mybike.data.database.AppDatabase
import com.example.mybike.data.local.dao.RideDAO
import com.example.mybike.data.repository.RideRepository
import com.example.mybike.data.repository.RideRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @ViewModelScoped
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getAppDatabase(context)
    }

    @Provides
    @ViewModelScoped
    fun provideRideDAO(appDatabase: AppDatabase): RideDAO {
        return appDatabase.getRideDAO()
    }

    @Provides
    @ViewModelScoped
    fun provideRideRepository(rideDAO: RideDAO): RideRepository {
        return RideRepositoryImpl(rideDAO)
    }
}