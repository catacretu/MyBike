package com.example.mybike.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BikeBuilder(
    bikeType: BikeType,
    scaleSize: Float,
    bikeColor: Color,
    modifier: Modifier
) {

    Box(
        modifier = modifier
            .wrapContentWidth()
            .height(160.dp)
    ) {

        Image(
            painter = painterResource(id = bikeType.bikeOver),
            contentDescription = "OverBike",
            modifier = Modifier
                .scale(scaleSize)
        )
        Image(
            painter = painterResource(id = bikeType.bikeMiddle),
            contentDescription = "MiddleBike",
            colorFilter = ColorFilter.tint(bikeColor),
            modifier = Modifier
                .scale(scaleSize)
        )
        Image(
            painter = painterResource(id = bikeType.bikeSmallWheels),
            contentDescription = "WheelsBike",
            modifier = Modifier
                .scale(scaleSize)
        )
    }
}