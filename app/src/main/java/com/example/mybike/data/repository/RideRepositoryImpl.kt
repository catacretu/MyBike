package com.example.mybike.data.repository

import com.example.mybike.data.local.dao.RideDAO
import com.example.mybike.data.local.model.RideEntity
import javax.inject.Inject

class RideRepositoryImpl @Inject constructor(
    private val rideDAO: RideDAO
) : RideRepository {
    override fun saveRide(rideEntity: RideEntity) {
        TODO("Not yet implemented")
    }

    override fun getRides(): List<RideEntity> {
        return rideDAO.getAllRides()
    }

    override fun updateRide(rideEntity: RideEntity) {
        TODO("Not yet implemented")
    }

    override fun deleteRide(rideEntity: RideEntity) {
        rideDAO.deleteRide(rideEntity)
    }
}