package com.example.mybike.components

import com.example.mybike.R

sealed class BikeType(
    val bikeOver: Int,
    val bikeMiddle: Int,
    val bikeSmallWheels: Int,
    val bikeBigWheels: Int
) {

    object ElectricBike : BikeType(
        R.drawable.bike_electric_over,
        R.drawable.bike_electric_middle,
        R.drawable.bike_electric_small_wheels,
        R.drawable.bike_electric_big_wheels
    )

    object HybridBike : BikeType(
        R.drawable.bike_hybrid_over,
        R.drawable.bike_hybrid_middle,
        R.drawable.bike_hybrid_small_wheels,
        R.drawable.bike_hybrid_big_wheels
    )

    object MTBike : BikeType(
        R.drawable.bike_mtb_over,
        R.drawable.bike_mtb_middle,
        R.drawable.bike_mtb_small_wheels,
        R.drawable.bike_mtb_big_wheels
    )

    object RoadBike : BikeType(
        R.drawable.bike_roadbike_over,
        R.drawable.bike_roadbike_middle,
        R.drawable.bike_roadbike_small_wheels,
        R.drawable.bike_roadbike_big_wheels
    )
}
