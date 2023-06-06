package com.example.mybike.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.mybike.R
import com.example.mybike.components.BikeBuilder
import com.example.mybike.components.BikeType
import com.example.mybike.components.ColorsList
import com.example.mybike.components.DropDownField
import com.example.mybike.components.SwitchButton
import com.example.mybike.components.TextFieldWithRequiredIcon
import com.example.mybike.ui.theme.Black
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddBikeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Bike", color = White) },
                backgroundColor = Black,
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painterResource(
                                id = R.drawable.icon_x
                            ),
                            contentDescription = "X Button",
                            tint = White
                        )
                    }
                }
            )
        }) {
        ConstraintLayout(
            modifier = Modifier
                .background(GreyBlue)
                .fillMaxSize(),
        )
        {
            val (bikeBox,
                colorsList,
                bike,
                bikeNameLabel,
                bikeNameField,
                wheelSizeField,
                serviceInField,
                defaultBikeField,
                switchButton,
                addBikeButton) = createRefs()

            ConstraintLayout(modifier = Modifier
                .height(250.dp)
                .background(Black)
                .constrainAs(bikeBox) {
                    bottom.linkTo(bikeNameField.top)
                    start.linkTo(parent.start)
                }) {

                ColorsList(modifier = Modifier
                    .padding(top = 10.dp)
                    .constrainAs(colorsList) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    })
                BikeBuilder(bikeType = BikeType.RoadBike,
                    size = 275.dp,
                    modifier = Modifier
                        .constrainAs(bike) {
                            centerVerticallyTo(parent)
                            centerHorizontallyTo(parent, 0.45f)

                        })
                Text(text = "Road Bike",
                    color = White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .constrainAs(bikeNameLabel) {
                            bottom.linkTo(parent.bottom, 32.dp)
                            centerHorizontallyTo(parent, 0.5f)
                        })
            }

            TextFieldWithRequiredIcon(
                fieldName = "Bike Name",
                fieldValue = "",
                modifierLayout = Modifier

                    .constrainAs(bikeNameField) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        centerVerticallyTo(parent, 0.37f)
                    },
                modifierTextField = Modifier.fillMaxWidth()
            )
            DropDownField(fieldName = "Wheel Size",
                listOfItems = arrayOf("29", "32"),
                modifier = Modifier
                    .constrainAs(wheelSizeField) {
                        top.linkTo(bikeNameField.bottom)
                        start.linkTo(parent.start)
                    })

            TextFieldWithRequiredIcon(
                fieldName = "Service In",
                fieldValue = "1000",
                measureUnit = "KM",
                modifierLayout = Modifier

                    .constrainAs(serviceInField) {
                        top.linkTo(wheelSizeField.bottom)
                        start.linkTo(parent.start)
                    },
                modifierTextField = Modifier.fillMaxWidth()
            )
            Text(text = "Default Bike",
                color = White,
                modifier = Modifier.constrainAs(defaultBikeField) {
                    top.linkTo(serviceInField.bottom, 30.dp)
                    start.linkTo(parent.start, 17.dp)
                })
            SwitchButton(modifier = Modifier
                .constrainAs(switchButton) {
                    top.linkTo(serviceInField.bottom, 19.dp)
                    end.linkTo(parent.end, 5.dp)
                })

            Button(
                onClick = {
                    navController.navigate("bike_screen") {
//                    popUpTo("add_bike_screen")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .constrainAs(addBikeButton) {
                        bottom.linkTo(parent.bottom, 10.dp)
                        start.linkTo(parent.start)
                    },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = LightBlue,
                    contentColor = White
                ),
            ) {
                Text("Add Button")
            }

        }
    }
}