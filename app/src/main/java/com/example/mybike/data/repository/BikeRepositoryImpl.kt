package com.example.mybike.data.repository

import com.example.mybike.data.local.dao.BikeDAO
import com.example.mybike.data.local.model.BikeEntity
import javax.inject.Inject

class BikeRepositoryImpl @Inject constructor(
    private val bikeDAO: BikeDAO
    ): BikeRepository {

    override fun saveBike(bikeEntity: BikeEntity) {
        bikeDAO.saveBike(bikeEntity)
    }

    override fun getBikes(): List<BikeEntity> {
        return bikeDAO.getAllBikes()
    }

    override fun getBikeById(bikeId: Int): BikeEntity {
        return bikeDAO.getBikeById(bikeId)
    }

    override fun updateBike(bikeEntity: BikeEntity) {
        bikeDAO.updateBike(bikeEntity)
    }

    override fun deleteBike(bikeEntity: BikeEntity) {
        bikeDAO.deleteBike(bikeEntity)
    }
}