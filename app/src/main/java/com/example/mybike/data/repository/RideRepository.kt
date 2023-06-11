package com.example.mybike.data.repository

import com.example.mybike.data.local.model.RideEntity

interface RideRepository {

    fun saveRide(rideEntity: RideEntity)
    fun getRides(): List<RideEntity>

    fun getRideById(rideId: Int): RideEntity

    fun updateRide(rideEntity: RideEntity)
    fun deleteRide(rideEntity: RideEntity)
}