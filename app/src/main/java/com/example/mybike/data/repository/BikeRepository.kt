package com.example.mybike.data.repository

import com.example.mybike.data.local.model.BikeEntity

interface BikeRepository {

    suspend fun saveBike(bikeEntity: BikeEntity)

    suspend fun getBikes(): List<BikeEntity>

    fun getBikeById(bikeId: Int): BikeEntity

    fun updateBike(bikeEntity: BikeEntity)

    suspend fun deleteBike(bikeEntity: BikeEntity)

}