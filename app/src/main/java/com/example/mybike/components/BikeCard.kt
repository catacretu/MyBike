package com.example.mybike.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mybike.R
import com.example.mybike.ui.theme.DarkBlue
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.GreyProgressBar
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@Preview(showBackground = true)
@Composable
fun BikeCard() {

    ConstraintLayout(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
//        .height(310.dp)
            .heightIn(min = 310.dp)
            .background(DarkBlue)
    ) {
        val (backgroundHalfColor,
            moreButton,
            bike,
            bikeName,
            bikeWheelsSize,
            bikeServiceIn,
            progressBar) = createRefs()

        val menuState = remember { mutableStateOf(false) }

        Box(modifier = Modifier
            .background(GreyBlue)
            .fillMaxWidth()
            .height(150.dp)
            .constrainAs(backgroundHalfColor) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            })
        IconButton(onClick = { menuState.value = !menuState.value },
            modifier = Modifier.constrainAs(moreButton) {
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
        MoreMenu(menuState = menuState)

        BikeBuilder(bikeType = BikeType.MTBike,
            size = 275.dp,
            modifier = Modifier
                .constrainAs(bike) {
                    centerVerticallyTo(parent, 0.2f)
                    centerHorizontallyTo(parent, 0.45f)

                })
        Text(text = "Nukeproof Scout 290",
            color = White,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(bikeName) {
                top.linkTo(bike.bottom, (-5).dp)
                start.linkTo(parent.start, 15.dp)
            }
        )

        Text(text = "Wheels: 29\"",
            color = White,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(bikeWheelsSize) {
                top.linkTo(bikeName.bottom)
                start.linkTo(parent.start, 15.dp)
            }
        )
        Text(text = "Service in 170km",
            color = White,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(bikeServiceIn) {
                top.linkTo(bikeWheelsSize.bottom)
                start.linkTo(parent.start, 15.dp)
            }
        )
        LinearProgressIndicator(
            progress = 0.6f,
            color = LightBlue,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .padding(start = 15.dp, end = 10.dp)
                .clip(RoundedCornerShape(16.dp))
                .constrainAs(progressBar) {
                    bottom.linkTo(parent.bottom, 20.dp)
                    start.linkTo(parent.start)
                },
            backgroundColor = GreyProgressBar,
            strokeCap = StrokeCap.Round
        )


    }
}