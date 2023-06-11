package com.example.mybike.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mybike.viewmodel.BikeViewModel
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
fun NavigationGraph(rideViewModel: RideViewModel, bikeViewModel: BikeViewModel) {
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
            BikeScreen(navController = navController, bikeViewModel)
        }
        composable("add_bike_screen") {
            AddBikeScreen(navController = navController, bikeViewModel)
        }
        composable("edit_bike_screen/{bikeId}",
            arguments = listOf(navArgument("bikeId"){type = NavType.StringType}))
        {backStackEntry->
            backStackEntry.arguments?.getString("bikeId")?.let{bikeId->
                EditBikeScreen(navController = navController, bikeId, bikeViewModel)
            }
        }

        composable("bike_details_screen/{bikeId}",
            arguments = listOf(navArgument("bikeId"){type = NavType.StringType}))
        {backStackEntry ->
            backStackEntry.arguments?.getString("bikeId")?.let {bikeId->
                BikeDetailsScreen(navController = navController,
                    bikeId,
                    bikeViewModel,
                    rideViewModel)
            }
        }

        composable("ride_screen") {
            RideScreen(navController = navController, rideViewModel)
        }

        composable("add_ride_screen") {
            AddRideScreen(navController = navController, bikeViewModel, rideViewModel)
        }
        composable("edit_ride_screen/{rideId}",
            arguments = listOf(navArgument("rideId"){type = NavType.StringType}))
        {backStackEntry ->
            backStackEntry.arguments?.getString("rideId")?.let {rideId->
                EditRideScreen(navController = navController,
                    rideId,
                    bikeViewModel,
                    rideViewModel)
            }
        }
        composable("settings_screen") {
            SettingsScreen(navController = navController, bikeViewModel)
        }
    }
}