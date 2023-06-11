package com.example.mybike.data.local.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bike_table")
 class BikeEntity (
    @PrimaryKey(autoGenerate = true)
    val bikeId: Int = 0,
    val bikeName: String,
    val bikeType: String,
    val bikeColor: Int,
    val wheelSize: String,
    val serviceIn: String
        )