package com.example.mybike.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mybike.data.local.model.RideEntity

@Dao
interface RideDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveRide(ride: RideEntity)

    @Query("SELECT * FROM ride_table")
    fun getAllRides(): List<RideEntity>
}