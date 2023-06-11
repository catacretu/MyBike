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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.mybike.R
import com.example.mybike.ui.theme.Black
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EmptyRideScreen(navController: NavController) {

        ConstraintLayout(
            modifier = Modifier
                .background(Black)
                .fillMaxSize(),
        )
        {
            val (missingRideCard, dotLine, addRideButton) = createRefs()
            Image(painter =
            painterResource(id = R.drawable.missing_ride),
                contentDescription = "",
                Modifier
                    .padding(10.dp)
                    .width(400.dp)
                    .height(200.dp)
                    .constrainAs(missingRideCard) {
                        top.linkTo(parent.top, 5.dp)
                        start.linkTo(parent.start)
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.curved_dotted_line),
                contentDescription = "",
                Modifier
                    .scale(1.21f)
                    .height(470.dp)
                    .constrainAs(dotLine) {
                        top.linkTo(missingRideCard.bottom, (-35).dp)
                        start.linkTo(missingRideCard.start, 10.dp)
                        centerHorizontallyTo(parent, bias = 0.11F)
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
                        bottom.linkTo(parent.bottom, 90.dp)
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