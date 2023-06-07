package com.example.mybike.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mybike.components.AddButtonWithText
import com.example.mybike.components.BikeCard
import com.example.mybike.components.BottomBar
import com.example.mybike.components.Title
import com.example.mybike.ui.theme.Black

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BikeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Title(text = "Bikes") },
                backgroundColor = Black,
                actions = {

                    AddButtonWithText(text = "Add Bike")
                }
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }) {

        LazyColumn(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ) {

            items(count = 4) {
                BikeCard()
            }
        }

    }
}
