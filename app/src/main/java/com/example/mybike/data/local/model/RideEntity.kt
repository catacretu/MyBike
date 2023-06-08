package com.example.mybike.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ride_table")
class RideEntity(
    @PrimaryKey(autoGenerate = true)
    val rideId: Int,
    val rideTitle: String,
    val bike: String,
    val distance: Int,
    val duration: String,
    val Date: String
)