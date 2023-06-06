package com.example.mybike.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.mybike.R
import com.example.mybike.components.BottomBar
import com.example.mybike.ui.theme.Black
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BikeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bikes", color = White) },
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
            val (missingBikeCard, dotLineBoxWithText, addBikeButton) = createRefs()
            Image(painter =
            painterResource(id = R.drawable.missing_bike_card),
                contentDescription = "",
                Modifier
                    .padding(end = 10.dp)
                    .fillMaxWidth()
                    .constrainAs(missingBikeCard) {
                        top.linkTo(parent.top, 5.dp)
                        start.linkTo(parent.start, 5.dp)
                    }
            )
            Box(modifier = Modifier
                .wrapContentSize()
                .constrainAs(dotLineBoxWithText) {
                    top.linkTo(missingBikeCard.bottom, 20.dp)
                    start.linkTo(missingBikeCard.start, 10.dp)
                    bottom.linkTo(addBikeButton.top)
                })
            {

                Image(
                    painter = painterResource(id = R.drawable.curved_dotted_line),
                    contentDescription = "",
                    Modifier
                        .height(285.dp)
                        .padding(start = 45.dp)

                )
                Text(
                    text = stringResource(R.string.NoBikeText),
                    fontSize = 18.sp,
                    color = Color.White,
                    style = TextStyle(background = Black),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(335.dp)
                        .padding(start = 50.dp, top = 108.dp)
                )
            }
            Button(
                onClick = {
                    navController.navigate("add_bike_screen") {
                        popUpTo("bike_screen")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .constrainAs(addBikeButton) {
                        top.linkTo(dotLineBoxWithText.bottom, 10.dp)
                        start.linkTo(parent.start)
                    },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = LightBlue,
                    contentColor = White
                ),
            ) {
                Text("Add Bike")
            }

        }
    }
}

