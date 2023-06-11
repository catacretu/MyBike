package com.example.mybike.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.graphics.toColorInt
import com.example.mybike.R
import com.example.mybike.data.local.model.BikeEntity
import com.example.mybike.ui.theme.BikeRed
import com.example.mybike.ui.theme.DarkBlue
import com.example.mybike.ui.theme.GreyProgressBar
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@Composable
fun BikeCard(bikeEntity: BikeEntity,
             editClick: () -> Unit,
             deleteClick: () -> Unit) {
    val listBikeTypes = mapOf("electric" to BikeType.ElectricBike,
                              "hybrid" to BikeType.HybridBike,
                              "mtb" to BikeType.MTBike,
                              "road" to BikeType.RoadBike)

    ConstraintLayout(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            .heightIn(min = 360.dp)
            .background(DarkBlue)
    ) {
        val (backgroundWave,
            moreButton,
            bike,
            bikeName,
            bikeWheelsSize,
            bikeServiceIn,
            progressBar) = createRefs()

        val menuState = remember { mutableStateOf(false) }
        val openDialog = remember { mutableStateOf(false) }

        Image(painter = painterResource(id = R.drawable.wave),
            contentDescription = "wave",
            modifier = Modifier
                .height(189.dp)
                .fillMaxWidth()
                .constrainAs(backgroundWave) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
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
        MoreMenu(menuState = menuState, openDialog = openDialog,
            editClick = editClick, deleteClick = deleteClick)

        listBikeTypes[bikeEntity.bikeType]?.let {
            BikeBuilder(bikeType = it,
                scaleSize = 2f,
                bikeColor = BikeRed,
                modifier = Modifier
                    .constrainAs(bike) {
                        centerVerticallyTo(parent, 0.5f)
                        centerHorizontallyTo(parent, 0.45f)

                    })
        }
        Text(text = "Nukeproof Scout 290",
            color = White,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(bikeName) {
                top.linkTo(bike.bottom, (-20).dp)
                start.linkTo(parent.start, 15.dp)
            }
        )

        Text(
            buildAnnotatedString {
                append("Wheels: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                    append("29\"")
                }
            },
            color = White,
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(bikeWheelsSize) {
                top.linkTo(bikeName.bottom)
                start.linkTo(parent.start, 15.dp)
            }
        )
        Text(buildAnnotatedString {
            append("Service in: ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                append("170km")
            }
        },
            color = White,
            fontSize = 20.sp,
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