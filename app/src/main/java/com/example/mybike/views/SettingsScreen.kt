package com.example.mybike.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.mybike.components.bottombar.BottomBar
import com.example.mybike.components.dropdown.DropDownField
import com.example.mybike.components.buttons.SwitchButton
import com.example.mybike.components.textcomponents.TextFieldWithRequiredIcon
import com.example.mybike.components.textcomponents.Title
import com.example.mybike.ui.theme.DarkBlue
import com.example.mybike.viewmodel.BikeViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingsScreen(navController: NavController,
                   bikeViewModel: BikeViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Title("Settings")
                        },
                backgroundColor = DarkBlue
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }) {

        ConstraintLayout(
            modifier = Modifier
                .background(DarkBlue)
                .fillMaxSize(),
        )
        {
            val listOfBikes = bikeViewModel.bikeData.map{it.bikeName}.toTypedArray()
            val distanceUnitValue = remember { mutableStateOf(TextFieldValue("KM")) }
            val serviceReminderValue = remember { mutableStateOf(TextFieldValue("100km")) }
            val enableServiceReminder = remember { mutableStateOf(true) }
            val defaultBikeValue = remember { mutableStateOf(TextFieldValue(listOfBikes[0])) }

            val (distanceUnitField,
                serviceReminderTextField,
                switchButton,
                defaultBike) = createRefs()

            DropDownField(fieldName = "Distance Units",
                listOfItems = arrayOf("KM", "Mi"),
                selectedItem = distanceUnitValue,
                modifier = Modifier
                    .constrainAs(distanceUnitField) {
                        top.linkTo(parent.top, 10.dp)
                        start.linkTo(parent.start)
                    }
            )
            TextFieldWithRequiredIcon(
                fieldName = "Service Reminder",
                fieldValue = serviceReminderValue,
                withIcon = false,
                modifierLayout = Modifier
                    .constrainAs(serviceReminderTextField) {
                        top.linkTo(distanceUnitField.bottom, 10.dp)
                        start.linkTo(parent.start)
                    },
                modifierTextField = Modifier.requiredWidth(360.dp)
            )

            SwitchButton(switchOn = enableServiceReminder,
                modifier = Modifier
                .constrainAs(switchButton) {
                    top.linkTo(serviceReminderTextField.top, 40.dp)
                    start.linkTo(serviceReminderTextField.end)
                })

            DropDownField(fieldName = "Default Bike",
                listOfItems = listOfBikes,
                selectedItem = defaultBikeValue,
                modifier = Modifier
                    .constrainAs(defaultBike) {
                        top.linkTo(switchButton.bottom, 10.dp)
                        start.linkTo(parent.start)
                    }
            )
        }
    }
}