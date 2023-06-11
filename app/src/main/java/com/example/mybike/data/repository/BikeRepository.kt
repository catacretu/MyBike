package com.example.mybike.data.repository

import com.example.mybike.data.local.model.BikeEntity

interface BikeRepository {

    fun saveBike(bikeEntity: BikeEntity)

    fun getBikes(): List<BikeEntity>

    fun updateBike(bikeEntity: BikeEntity)

    fun deleteBike(bikeEntity: BikeEntity)

}