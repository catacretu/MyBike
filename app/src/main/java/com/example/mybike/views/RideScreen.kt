package com.example.mybike.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.example.mybike.viewmodel.RideViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RideScreen(navController: NavController,
               rideViewModel: RideViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Title(text = "Rides") },
                backgroundColor = Black,
                actions = {
                    if(rideViewModel.rideData.isNotEmpty())
                        AddButtonWithText(text = "Add Ride")
                        {navController.navigate("add_ride_screen"){
                            popUpTo("ride_screen")
                        }}}
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }) {paddingValues ->
        if(rideViewModel.rideData.isEmpty())
            EmptyRideScreen(navController = navController)
        else
            RideScreenContent(navController = navController,
                rideViewModel = rideViewModel,
                paddingValues)
    }
}

@Composable
fun RideScreenContent(navController: NavController,
                      rideViewModel: RideViewModel,
                      paddingValues: PaddingValues) {
    val ridesList = rideViewModel.rideData
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

//        LaunchedEffect(rideViewModel.rideData) {
//            snapshotFlow { rideViewModel.rideData }
//                .collect { newList ->
//                     = newList
//                }
//        }

        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
        ) {

            items(key = {it},count = ridesList.size) {index->
                RideCard(rideEntity = ridesList[index],
                    editClick = {navController.navigate("edit_ride_screen"){
                        popUpTo("bike_screen")
                    }},
                    deleteClick = {rideViewModel.deleteRide(ridesList[index])})

            }
        }

    }
}