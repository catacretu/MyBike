package com.example.mybike

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Bikes : BottomNavItem("Bikes", R.drawable.icon_bikes_inactive, "bikes")
    object Rides : BottomNavItem("Rides", R.drawable.icon_rides_inactive, "rides")
    object Settings : BottomNavItem("Settings", R.drawable.icon_settings_inactive, "settings")
}