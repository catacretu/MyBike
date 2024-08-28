package com.example.mybike.data.repository

import com.example.mybike.data.local.model.RideEntity

interface RideRepository {

    suspend fun saveRide(rideEntity: RideEntity)
    suspend fun getRides(): List<RideEntity>

    fun getRideById(rideId: Int): RideEntity

    fun updateRide(rideEntity: RideEntity)
    suspend fun deleteRide(rideEntity: RideEntity)
}