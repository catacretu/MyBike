package com.example.mybike.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.mybike.R
import com.example.mybike.components.BottomBar
import com.example.mybike.ui.theme.Black
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RideScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Rides", color = White) },
                backgroundColor = Black
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }) {
        ConstraintLayout(
            modifier = Modifier
                .background(Black)
                .fillMaxSize(),
        )
        {
            val (missingRideCard, dotLine, addRideButton) = createRefs()
            Image(painter =
            painterResource(id = R.drawable.missing_ride_card),
                contentDescription = "",
                Modifier
                    .padding(end = 10.dp)
                    .fillMaxWidth()
                    .constrainAs(missingRideCard) {
                        top.linkTo(parent.top, 5.dp)
                        start.linkTo(parent.start, 5.dp)
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.curved_dotted_line),
                contentDescription = "",
                Modifier
                    .width(200.dp)
                    .height(500.dp)
//                    .size(400.dp)
                    .constrainAs(dotLine) {
                        top.linkTo(missingRideCard.bottom, 5.dp)
                        start.linkTo(missingRideCard.start, 10.dp)
                        centerHorizontallyTo(parent, bias = 0.03F)
                    }
            )

            Button(
                onClick = {
                    navController.navigate("add_ride_screen") {
                        popUpTo("ride_screen")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .constrainAs(addRideButton) {
                        top.linkTo(dotLine.bottom, 10.dp)
                        start.linkTo(parent.start)
                    },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = LightBlue,
                    contentColor = White
                ),
            ) {
                Text("Add Ride")
            }
        }
    }
}