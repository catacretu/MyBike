package com.example.mybike.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mybike.components.AddButtonWithText
import com.example.mybike.components.BottomBar
import com.example.mybike.components.RideCard
import com.example.mybike.components.Title
import com.example.mybike.ui.theme.Black
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.MonthGrey

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RideScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Title(text = "Rides") },
                backgroundColor = Black,
                actions = {
                    AddButtonWithText(text = "Add Ride")
                }
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }) {
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize(),
        )
        {

            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(GreyBlue)
            )
            Text(
                text = "March",
                color = MonthGrey,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp, bottom = 5.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                items(count = 4) {
                    RideCard()
                }
            }

        }
    }
}