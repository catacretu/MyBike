package com.example.mybike.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mybike.R
import com.example.mybike.data.local.model.RideEntity
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.White


@Composable
fun RideCard(rideEntity: RideEntity,
             editClick: () -> Unit,
             deleteClick: () -> Unit) {

    ConstraintLayout(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            .height(150.dp)
            .fillMaxWidth()
            .background(GreyBlue)
    ) {
        val menuState = remember { mutableStateOf(false) }
        val openDialog = remember { mutableStateOf(false) }

        val (
            title,
            bikeIcon,
            moreButton,
            bikeNameField,
            distanceField,
            durationField,
            dateField) = createRefs()

        Icon(
            painterResource(
                id = R.drawable.icon_bikes_inactive
            ),
            contentDescription = "Bike Icon",
            tint = White,
            modifier = Modifier
                .scale(0.7f)
                .constrainAs(bikeIcon) {
                    top.linkTo(parent.top, 16.dp)
                    start.linkTo(parent.start, 15.dp)
                })

        Title(text = rideEntity.rideTitle,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top, 12.dp)
                    start.linkTo(bikeIcon.end, 8.dp)
                })

        IconButton(onClick = {
            menuState.value = !menuState.value
        }, modifier = Modifier.constrainAs(moreButton) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
        }
        ) {
            Icon(
                painterResource(
                    id = R.drawable.icon_more
                ),
                contentDescription = "More Button",
                tint = White
            )
        }
        MoreMenu(menuState, openDialog,editClick,deleteClick)

        TextWithValue(label = "Bike: ",
            value = rideEntity.bikeName,
            modifier = Modifier.constrainAs(bikeNameField) {
                top.linkTo(title.bottom)
                start.linkTo(parent.start, 20.dp)
            })
        TextWithValue(label = "Distance: ",
            value = rideEntity.distance,
            modifier = Modifier.constrainAs(distanceField) {
                top.linkTo(bikeNameField.bottom)
                start.linkTo(parent.start, 20.dp)
            })

        TextWithValue(label = "Duration: ",
            value = rideEntity.duration,
            modifier = Modifier.constrainAs(durationField) {
                top.linkTo(distanceField.bottom)
                start.linkTo(parent.start, 20.dp)
            })

        TextWithValue(label = "Date: ",
            value = rideEntity.date,
            modifier = Modifier.constrainAs(dateField) {
                top.linkTo(durationField.bottom)
                start.linkTo(parent.start, 20.dp)
            })
    }
}