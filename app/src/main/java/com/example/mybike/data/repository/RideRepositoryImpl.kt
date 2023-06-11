package com.example.mybike.data.repository

import com.example.mybike.data.local.dao.RideDAO
import com.example.mybike.data.local.model.RideEntity
import javax.inject.Inject

class RideRepositoryImpl @Inject constructor(
    private val rideDAO: RideDAO
) : RideRepository {
    override fun saveRide(rideEntity: RideEntity) {
        rideDAO.saveRide(rideEntity)
    }

    override fun getRides(): List<RideEntity> {
        return rideDAO.getAllRides()
    }

    override fun getRideById(rideId: Int): RideEntity {
        return rideDAO.getRideById(rideId)
    }

    override fun updateRide(rideEntity: RideEntity) {
        rideDAO.updateRide(rideEntity)
    }

    override fun deleteRide(rideEntity: RideEntity) {
        rideDAO.deleteRide(rideEntity)
    }
}