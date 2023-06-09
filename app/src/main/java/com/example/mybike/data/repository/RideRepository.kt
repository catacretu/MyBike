package com.example.mybike.data.repository

import com.example.mybike.data.local.model.RideEntity

interface RideRepository {

    fun getRides(): List<RideEntity>
    fun deleteRide(rideEntity: RideEntity)
}