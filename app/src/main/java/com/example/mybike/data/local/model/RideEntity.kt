package com.example.mybike.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ride_table")
class RideEntity(
    @PrimaryKey(autoGenerate = true)
    val rideId: Int =0,
    val rideTitle: String,
    val bikeName: String,
    val distance: String,
    val duration: String,
    val date: String
)