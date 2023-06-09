package com.example.mybike.data.repository

import com.example.mybike.data.local.dao.RideDAO
import com.example.mybike.data.local.model.RideEntity
import javax.inject.Inject

class RideRepositoryImpl @Inject constructor(
    private val rideDAO: RideDAO
) : RideRepository {
    override fun getRides(): List<RideEntity> {
        return rideDAO.getAllRides()
    }

    override fun deleteRide(rideEntity: RideEntity) {
        rideDAO.deleteRide(rideEntity)
    }
}