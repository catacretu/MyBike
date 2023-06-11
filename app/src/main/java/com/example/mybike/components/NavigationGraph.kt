package com.example.mybike.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybike.viewmodel.RideViewModel
import com.example.mybike.views.AddBikeScreen
import com.example.mybike.views.AddRideScreen
import com.example.mybike.views.BikeDetailsScreen
import com.example.mybike.views.BikeScreen
import com.example.mybike.views.EditBikeScreen
import com.example.mybike.views.EditRideScreen
import com.example.mybike.views.EmptyBikeScreen
import com.example.mybike.views.RideScreen
import com.example.mybike.views.SettingsScreen
import com.example.mybike.views.SplashScreen

@Composable
fun NavigationGraph(rideViewModel: RideViewModel) {
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
        composable("edit_bike_screen") {
            EditBikeScreen(navController = navController)
        }

        composable("bike_details_screen") {
           BikeDetailsScreen(navController = navController, rideViewModel)
        }

        composable("ride_screen") {
            RideScreen(navController = navController, rideViewModel)
        }

        composable("add_ride_screen") {
            AddRideScreen(navController = navController)
        }
        composable("edit_ride_screen") {
            EditRideScreen(navController = navController)
        }
        composable("settings_screen") {
            SettingsScreen(navController = navController)
        }
    }
}