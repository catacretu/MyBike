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
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mybike.BottomNavItem
import com.example.mybike.R
import com.example.mybike.ui.theme.Black
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.SelectedIconColor
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
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = screen.icon),
                        contentDescription = screen.title
                    )
                },
                label = {
                    Text(
                        text = screen.title,
                        fontSize = 12.sp
                    )
                },
                selectedContentColor = SelectedIconColor,
                unselectedContentColor = White,
                alwaysShowLabel = true,
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {

                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}