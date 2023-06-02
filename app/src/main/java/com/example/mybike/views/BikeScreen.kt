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
import androidx.compose.runtime.getValue
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
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mybike.BottomNavItem
import com.example.mybike.R
import com.example.mybike.ui.theme.Black
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bikes", color = White) },
                backgroundColor = Black
            )
        },
        bottomBar = {
            BottomNavigation(navController = navController)
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
                        .padding(start = 45.dp)
                        .height(285.dp)
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
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .constrainAs(addBikeButton) {
                        top.linkTo(dotLineBoxWithText.bottom, 10.dp)
                        start.linkTo(parent.start)
                    },
                colors = ButtonDefaults.buttonColors(backgroundColor = LightBlue),
            ) {
                Text("Add Bike")
            }

        }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Bikes,
        BottomNavItem.Rides,
        BottomNavItem.Settings
    )
    BottomNavigation(
        backgroundColor = GreyBlue,
        contentColor = White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp
                    )
                },
//                selectedContentColor = White,
//                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        //Single Top means that if you launch an activity
                        // that is already on top, it wont be created again just resumed.
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}