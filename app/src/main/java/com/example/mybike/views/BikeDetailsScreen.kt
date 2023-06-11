package com.example.mybike.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.mybike.R
import com.example.mybike.components.BackButtonWithText
import com.example.mybike.components.BikeBuilder
import com.example.mybike.components.BikeType
import com.example.mybike.components.RideCard
import com.example.mybike.components.TextWithValue
import com.example.mybike.ui.theme.BikeRed
import com.example.mybike.ui.theme.Black
import com.example.mybike.ui.theme.DarkBlue
import com.example.mybike.ui.theme.Grey
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.GreyProgressBar
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White
import com.example.mybike.viewmodel.RideViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BikeDetailsScreen(navController: NavController,
                      rideViewModel: RideViewModel) {
    val ridesList = rideViewModel.rideData
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    BackButtonWithText(text = "MyBike") {
                    navController.navigate("bike_screen"){
                        popUpTo("bike_details_screen")
                }}
                        },
                backgroundColor = Black,
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painterResource(
                                id = R.drawable.icon_more
                            ),
                            contentDescription = "More Button",
                            tint = White
                        )
                    }
                }
            )
        }) {paddingValues ->
        ConstraintLayout(
            modifier = Modifier
                .background(DarkBlue)
                .fillMaxSize(),
        ) {

            val (backgroundWave,
                bikeBox,
                bike,
                bikeWheelsSize,
                bikeServiceIn,
                progressBar,
                rideNumber,
                totalDistance,
                ridesLabel,
                listOfRides) = createRefs()

            ConstraintLayout(modifier = Modifier
                .height(270.dp)
                .background(Black)
                .constrainAs(bikeBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }) {

                Image(painter = painterResource(id = R.drawable.wave),
                    contentDescription = "wave",
                    colorFilter = ColorFilter.tint(DarkBlue),
                    modifier = Modifier
                        .scale(1.2f)
                        .fillMaxWidth()
                        .constrainAs(backgroundWave) {
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)
                        })


                BikeBuilder(bikeType = BikeType.MTBike,
                    scaleSize = 2f,
                    bikeColor = BikeRed,
                    modifier = Modifier
                        .constrainAs(bike) {
                            centerVerticallyTo(parent, 0.5f)
                            centerHorizontallyTo(parent, 0.45f)

                        })

                Text(
                    buildAnnotatedString {
                        append("Wheels: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append("28\"")
                        }
                    },
                    color = White,
                    fontSize = 20.sp,
                    modifier = Modifier.constrainAs(bikeWheelsSize) {
                        top.linkTo(bike.bottom)
                        start.linkTo(parent.start, 15.dp)
                    }
                )
                Text(
                    buildAnnotatedString {
                        append("Service in: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append("170km")
                        }
                    },
                    color = White,
                    fontSize = 20.sp,
                    modifier = Modifier.constrainAs(bikeServiceIn) {
                        top.linkTo(bikeWheelsSize.bottom)
                        start.linkTo(parent.start, 15.dp)
                    }
                )
                LinearProgressIndicator(
                    progress = 0.6f,
                    color = LightBlue,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .padding(start = 15.dp, end = 10.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .constrainAs(progressBar) {
                            top.linkTo(bikeServiceIn.bottom, 20.dp)
                            start.linkTo(parent.start)
                        },
                    backgroundColor = GreyProgressBar,
                    strokeCap = StrokeCap.Round
                )
            }
                TextWithValue(label = "Rides ", value = "3",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.constrainAs(rideNumber) {
                        top.linkTo(bikeBox.bottom, 40.dp)
                        start.linkTo(parent.start, 15.dp)
                    })

                TextWithValue(label = "Total Rides Distance ", value = " 450km",
                    fontSize = 20.sp,
                    modifier = Modifier.constrainAs(totalDistance) {
                        top.linkTo(rideNumber.bottom)
                        start.linkTo(parent.start, 15.dp)
                    })


                Text(text = "RIDES", fontSize = 20.sp,
                    color = Grey, modifier = Modifier.
                            constrainAs(ridesLabel){
                                top.linkTo(totalDistance.bottom,20.dp)
                                start.linkTo(parent.start, 15.dp)
                            }
                )
                LazyColumn(
                    contentPadding = paddingValues,
                    modifier = Modifier
                        .height(400.dp)
                        .constrainAs(listOfRides){
                            top.linkTo(ridesLabel.bottom,10.dp)
                            start.linkTo(parent.start)
                        }
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
    }