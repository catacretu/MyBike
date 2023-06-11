package com.example.mybike.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mybike.data.local.model.BikeEntity

@Dao
interface BikeDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveBike(bike: BikeEntity)

    @Query("SELECT * FROM bike_table")
    fun getAllBikes(): List<BikeEntity>

    @Query("SELECT * FROM bike_table WHERE bikeId = :bikeId")
    fun getBikeById(bikeId: Int): BikeEntity

    @Update
    fun updateBike(bike: BikeEntity)

    @Delete
    fun deleteBike(bike: BikeEntity)

}