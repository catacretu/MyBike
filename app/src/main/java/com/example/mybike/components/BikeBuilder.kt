package com.example.mybike.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mybike.ui.theme.BikeRed

@Composable
fun BikeBuilder(
    bikeType: BikeType,
    size: Dp,
//                selectedColor: Color,
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
                .width(size)
                .height(size)
        )
        Image(
            painter = painterResource(id = bikeType.bikeMiddle),
            contentDescription = "MiddleBike",
            colorFilter = ColorFilter.tint(BikeRed),
            modifier = Modifier
                .width(size)
                .height(size)
        )
        Image(
            painter = painterResource(id = bikeType.bikeSmallWheels),
            contentDescription = "WheelsBike",
            modifier = Modifier
                .width(size)
                .height(size)
        )
    }
}