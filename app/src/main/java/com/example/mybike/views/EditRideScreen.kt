package com.example.mybike.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.mybike.R
import com.example.mybike.components.dropdown.DropDownField
import com.example.mybike.components.textcomponents.TextFieldWithRequiredIcon
import com.example.mybike.data.local.model.RideEntity
import com.example.mybike.ui.theme.DarkBlue
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White
import com.example.mybike.viewmodel.BikeViewModel
import com.example.mybike.viewmodel.RideViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditRideScreen(navController: NavController,
                   rideId: String,
                   bikeViewModel: BikeViewModel,
                   rideViewModel: RideViewModel
                   ) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Ride", color = White) },
                backgroundColor = DarkBlue,
                actions = {
                    IconButton(onClick = {navController.navigate("ride_screen"){
                        popUpTo("edit_ride_screen")
                    }}) {
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
                .background(DarkBlue)
                .fillMaxSize(),
        )
        {
            val rideEntity = rideViewModel.getRideById(rideId.toInt())
            val listOfBikes = bikeViewModel.bikeData.map{it.bikeName}.toTypedArray()
            val rideTitleValue = remember { mutableStateOf(TextFieldValue(rideEntity.rideTitle)) }
            val bikeNameValue = remember { mutableStateOf(TextFieldValue(rideEntity.bikeName)) }
            val distanceValue = remember { mutableStateOf(TextFieldValue(rideEntity.distance)) }
            val durationValue = remember { mutableStateOf(TextFieldValue(rideEntity.duration)) }
            val dateValue = remember { mutableStateOf(TextFieldValue(rideEntity.date)) }

            val (rideTitleField,
                bikeField,
                distanceField,
                durationField,
                dateField,
                addRideButton) = createRefs()
            TextFieldWithRequiredIcon(
                fieldName = "Ride Title",
                fieldValue = rideTitleValue,
                withIcon = false,
                modifierLayout = Modifier

                    .constrainAs(rideTitleField) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                modifierTextField = Modifier.fillMaxWidth()
            )

            DropDownField(fieldName = "Bike",
                listOfItems = listOfBikes,
                selectedItem = bikeNameValue,
                modifier = Modifier
                    .constrainAs(bikeField) {
                        top.linkTo(rideTitleField.bottom)
                        start.linkTo(parent.start)
                    })

            TextFieldWithRequiredIcon(
                fieldName = "Distance",
                fieldValue = distanceValue,
                measureUnit = "KM",
                modifierLayout = Modifier
                    .constrainAs(distanceField) {
                        top.linkTo(bikeField.bottom)
                        start.linkTo(parent.start)
                    },
                modifierTextField = Modifier.fillMaxWidth()
            )

            TextFieldWithRequiredIcon(
                fieldName = "Duration",
                fieldValue = durationValue,
                modifierLayout = Modifier
                    .constrainAs(durationField) {
                        top.linkTo(distanceField.bottom)
                        start.linkTo(parent.start)
                    },
                modifierTextField = Modifier.fillMaxWidth()
            )

            TextFieldWithRequiredIcon(
                fieldName = "Date",
                fieldValue = dateValue,
                modifierLayout = Modifier
                    .constrainAs(dateField) {
                        top.linkTo(durationField.bottom)
                        start.linkTo(parent.start)
                    },
                modifierTextField = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    rideViewModel.updateRide(
                        RideEntity(
                            rideId = rideId.toInt(),
                            rideTitle = rideTitleValue.value.text,
                            bikeName = bikeNameValue.value.text,
                            distance = distanceValue.value.text,
                            duration = durationValue.value.text,
                            date = dateValue.value.text
                        )
                    )
                    navController.navigate("ride_screen") {
                        popUpTo("add_ride_screen")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .constrainAs(addRideButton) {
                        bottom.linkTo(parent.bottom, 10.dp)
                        start.linkTo(parent.start)
                    },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = LightBlue,
                    contentColor = White
                ),
            ) {
                Text("Save", fontSize = 15.sp)
            }
        }
    }

}