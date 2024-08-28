package com.example.mybike.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mybike.data.local.model.RideEntity

@Dao
interface RideDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveRide(ride: RideEntity)

    @Query("SELECT * FROM ride_table")
    suspend fun getAllRides(): List<RideEntity>

    @Query("SELECT * FROM ride_table WHERE rideId = :rideId")
    fun getRideById(rideId: Int): RideEntity

    @Update
    fun updateRide(ride: RideEntity)

    @Delete
    suspend fun deleteRide(ride: RideEntity)
}