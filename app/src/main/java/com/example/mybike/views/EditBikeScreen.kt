package com.example.mybike.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.mybike.R
import com.example.mybike.components.bikecomponents.BikeBuilder
import com.example.mybike.components.bikecomponents.BikeType
import com.example.mybike.components.bikecomponents.ColorsList
import com.example.mybike.components.dropdown.DropDownField
import com.example.mybike.components.buttons.SwitchButton
import com.example.mybike.components.textcomponents.TextFieldWithRequiredIcon
import com.example.mybike.components.bikecomponents.listBikeTypes
import com.example.mybike.data.local.model.BikeEntity
import com.example.mybike.ui.theme.Black
import com.example.mybike.ui.theme.DarkBlue
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White
import com.example.mybike.viewmodel.BikeViewModel

@SuppressLint("Range")
@Composable
fun EditBikeScreen(navController: NavController,
                   bikeId: String,
                   bikeViewModel: BikeViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Bike", color = White)},
                backgroundColor = Black,
                actions = {
                    IconButton(onClick = {navController.navigate("bike_screen"){
                        popUpTo("edit_bike_screen")
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
        }) { paddingValues ->
        ConstraintLayout(
            modifier = Modifier
                .background(DarkBlue)
                .fillMaxSize(),
        )
        {
            val bikeEntity = bikeViewModel.getBikeById(bikeId.toInt())

            val bikeNameValue = remember { mutableStateOf(TextFieldValue(bikeEntity.bikeName)) }
            val wheelSizeValue = remember { mutableStateOf(TextFieldValue(bikeEntity.wheelSize)) }
            val serviceInValue = remember { mutableStateOf(TextFieldValue(bikeEntity.serviceIn)) }
            val selectedColor = remember { mutableStateOf(Color(bikeEntity.bikeColor)) }
            val selectedBike = remember { mutableStateOf(bikeEntity.bikeType) }
            val defaultBike = remember { mutableStateOf(bikeEntity.defaultBike) }
            val (bikeBox,
                colorsList,
                bike,
                bikeNameLabel,
                bikeNameField,
                backgroundWave,
                wheelSizeField,
                serviceInField,
                defaultBikeField,
                switchButton,
                addBikeButton) = createRefs()

            ConstraintLayout(modifier = Modifier
                .height(270.dp)
                .background(Black)
                .constrainAs(bikeBox) {
                    bottom.linkTo(bikeNameField.top)
                    start.linkTo(parent.start)
                }) {

                Image(painter = painterResource(id = R.drawable.wave),
                    contentDescription = "wave",
                    colorFilter = ColorFilter.tint(DarkBlue),
                    modifier = Modifier
                        .scale(1.2f)
                        .fillMaxWidth()
                        .constrainAs(backgroundWave) {
                            centerVerticallyTo(parent, 1.4f)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                        })

                ColorsList(
                    selectedColor = selectedColor,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .constrainAs(colorsList) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        })
                val listOfBikes = listOf(
                    BikeType.ElectricBike,
                    BikeType.HybridBike,
                    BikeType.MTBike,
                    BikeType.RoadBike)

                LazyRow(horizontalArrangement = Arrangement.spacedBy(130.dp),
                    contentPadding = paddingValues,
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(bike) {
                            centerVerticallyTo(parent, 1f)
                            centerHorizontallyTo(parent, 0.45f)
                        }
                ){
                    items(count = listOfBikes.size){index->
                        BikeBuilder(bikeType = listBikeTypes.values.elementAt(index),
                            scaleSize = 1.8f,
                            bikeColor = selectedColor.value,
                            onClick = {
                                selectedBike.value = listBikeTypes.keys.elementAt(index)
                            },
                            modifier = Modifier
                        )
                    }
                }

                Text(
                    text = selectedBike.value,
                    color = White,
                    fontSize = 17.sp,
                    modifier = Modifier
                        .constrainAs(bikeNameLabel) {
                            bottom.linkTo(parent.bottom)
                            centerHorizontallyTo(parent, 0.5f)
                        })
            }

            TextFieldWithRequiredIcon(
                fieldName = "Bike Name",
                fieldValue = bikeNameValue,
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
                selectedItem = wheelSizeValue,
                modifier = Modifier
                    .constrainAs(wheelSizeField) {
                        top.linkTo(bikeNameField.bottom)
                        start.linkTo(parent.start)
                    })

            TextFieldWithRequiredIcon(
                fieldName = "Service In",
                fieldValue = serviceInValue,
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
            SwitchButton(switchOn = defaultBike,
                modifier = Modifier
                .constrainAs(switchButton) {
                    top.linkTo(serviceInField.bottom, 19.dp)
                    end.linkTo(parent.end, 5.dp)
                })

            Button(
                onClick = {
                    bikeViewModel.updateBike(
                        BikeEntity(
                            bikeId = bikeId.toInt(),
                            bikeName = bikeNameValue.value.text,
                            bikeType = selectedBike.value,
                            bikeColor = selectedColor.value.toArgb(),
                            wheelSize = wheelSizeValue.value.text,
                            serviceIn = serviceInValue.value.text,
                            defaultBike = defaultBike.value
                        )
                    )
                    navController.navigate("bike_screen") {
                    popUpTo("edit_bike_screen")
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
                Text("Save")
            }

        }
    }
}