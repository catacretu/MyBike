package com.example.mybike.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mybike.R
import com.example.mybike.ui.theme.White

@Composable
fun DropDownField(
    fieldName: String,
    listOfItems: Array<String>,
    modifier: Modifier
) {
    ConstraintLayout(
        modifier = modifier

    ) {
        val (distanceUnitText,
            iconRequired,
            distanceUnitList) = createRefs()
        Text(text = fieldName,
            fontSize = 12.sp,
            color = White,
            modifier = Modifier
                .padding(start = 1.dp)
                .constrainAs(distanceUnitText) {
                    top.linkTo(parent.top, 15.dp)
                    start.linkTo(parent.start, 10.dp)
                }
        )
        Icon(
            painterResource(
                id = R.drawable.icon_required
            ),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier
                .constrainAs(iconRequired) {
                    top.linkTo(parent.top, 15.dp)
                    start.linkTo(distanceUnitText.end, 1.dp)
                })
        DropDownList(
            listOfItems = listOfItems,
            modifierTextField = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(
                    start = 10.dp,
                    end = 10.dp
                )
                .border(
                    BorderStroke(0.1.dp, White),
                    RoundedCornerShape(4.dp)
                ),
            modifierDropDownList = Modifier
                .constrainAs(distanceUnitList) {
                    top.linkTo(distanceUnitText.bottom, 5.dp)
                    start.linkTo(parent.start)
                }
        )
    }

}