package com.example.mybike.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mybike.components.AddButtonWithText
import com.example.mybike.components.BikeCard
import com.example.mybike.components.BottomBar
import com.example.mybike.components.Title
import com.example.mybike.ui.theme.Black
import com.example.mybike.viewmodel.BikeViewModel

@Composable
fun BikeScreen(navController: NavController, bikeViewModel: BikeViewModel) {
    val bikesList = bikeViewModel.bikeData
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if(bikeViewModel.bikeData.isNotEmpty())
                        Title(text = "Bikes")
                    else
                        Title(text = "Bikes", modifier = Modifier.padding(top = 34.dp))},
                backgroundColor = Black,
                actions = {
                  if(bikeViewModel.bikeData.isNotEmpty())
                    AddButtonWithText(text = "Add Bike") {
                        navController.navigate("add_bike_screen") {
                            popUpTo("bike_screen")
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }) { paddingValues ->

        if (bikeViewModel.bikeData.isEmpty())
            EmptyBikeScreen(navController = navController)
        else {
            BikeScreenContent(navController = navController,
                              bikeViewModel = bikeViewModel, paddingValues =paddingValues )
        }
    }
}

@Composable
fun BikeScreenContent(navController: NavController,
                      bikeViewModel: BikeViewModel,
                      paddingValues: PaddingValues) {
    val bikesList = bikeViewModel.bikeData
    LazyColumn(
        contentPadding = paddingValues,
        modifier = Modifier
            .background(Black)
            .fillMaxSize()
            .clickable(onClick = {
                navController.navigate("bike_details_screen") {
                    popUpTo("bike_screen")
                }
            })
    )
    {

        items(count = bikesList.size) { index ->
            BikeCard(
                bikesList[index],
                editClick = {
                    navController.navigate("edit_bike_screen") {
                        popUpTo("bike_screen")
                    }
                }, deleteClick = {})
        }
    }


}
