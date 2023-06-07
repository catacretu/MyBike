package com.example.mybike.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybike.views.AddBikeScreen
import com.example.mybike.views.AddRideScreen
import com.example.mybike.views.BikeScreen
import com.example.mybike.views.EmptyBikeScreen
import com.example.mybike.views.RideScreen
import com.example.mybike.views.SettingsScreen
import com.example.mybike.views.SplashScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    )
    {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }

        composable("empty_bike_screen") {
            EmptyBikeScreen(navController = navController)
        }
        composable("bike_screen") {
            BikeScreen(navController = navController)
        }
        composable("add_bike_screen") {
            AddBikeScreen(navController = navController)
        }
        composable("ride_screen") {
            RideScreen(navController = navController)
        }
        composable("add_ride_screen") {
            AddRideScreen(navController = navController)
        }
        composable("settings_screen") {
            SettingsScreen(navController = navController)
        }
    }
}