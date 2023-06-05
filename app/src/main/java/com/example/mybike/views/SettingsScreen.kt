package com.example.mybike.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.mybike.components.BottomBar
import com.example.mybike.components.DropDownField
import com.example.mybike.components.SwitchButton
import com.example.mybike.components.TextFieldWithIcon
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings", color = White) },
                backgroundColor = GreyBlue
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }) {

        ConstraintLayout(
            modifier = Modifier
                .background(GreyBlue)
                .fillMaxSize(),
        )
        {
            val (distanceUnitField,
                serviceReminderTextField,
                switchButton,
                defaultBike) = createRefs()

            DropDownField(fieldName = "Distance Units",
                listOfItems = arrayOf("KM", "Mi"),
                modifier = Modifier
                    .constrainAs(distanceUnitField) {
                        top.linkTo(parent.top, 10.dp)
                        start.linkTo(parent.start)
                    }
            )
            TextFieldWithIcon(
                fieldName = "Service Reminder",
                fieldValue = "100km",
                withIcon = false,
                modifierLayout = Modifier
                    .constrainAs(serviceReminderTextField) {
                        top.linkTo(distanceUnitField.bottom, 10.dp)
                        start.linkTo(parent.start)
                    },
                modifierTextField = Modifier.requiredWidth(360.dp)
            )

            SwitchButton(modifier = Modifier
                .constrainAs(switchButton) {
                    top.linkTo(serviceReminderTextField.top, 40.dp)
                    start.linkTo(serviceReminderTextField.end)
                })

            DropDownField(fieldName = "Default Bike",
                listOfItems = arrayOf("KM", "Mi"),
                modifier = Modifier
                    .constrainAs(defaultBike) {
                        top.linkTo(switchButton.bottom, 10.dp)
                        start.linkTo(parent.start)
                    }
            )
        }
    }
}