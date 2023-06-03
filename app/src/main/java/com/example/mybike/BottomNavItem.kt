package com.example.mybike

sealed class BottomNavItem(val title: String, val icon: Int, val route: String) {

    object Bikes : BottomNavItem("Bikes", R.drawable.icon_bikes_inactive, "bike_screen")
    object Rides : BottomNavItem("Rides", R.drawable.icon_rides_inactive, "ride_screen")
    object Settings :
        BottomNavItem("Settings", R.drawable.icon_settings_inactive, "settings_screen")
}