package com.example.mybike.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@Composable
fun OptionalTextField(
    fieldName: String,
    modifier: Modifier
) {
    ConstraintLayout(
        modifier = modifier

    ) {
        val (serviceReminderText,
            serviceReminderTextField) = createRefs()

        val customTextSelectionColors = TextSelectionColors(
            handleColor = LightBlue,
            backgroundColor = LightBlue
        )

        Text(text = fieldName,
            fontSize = 12.sp,
            color = White,
            modifier = Modifier
                .padding(start = 1.dp)
                .constrainAs(serviceReminderText) {
                    top.linkTo(parent.top, 15.dp)
                    start.linkTo(parent.start, 10.dp)
                }
        )

        CompositionLocalProvider(
            LocalTextSelectionColors provides customTextSelectionColors
        ) {
            TextField(value = "100km",
                onValueChange = {},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = GreyBlue,
                    textColor = White,
                    cursorColor = LightBlue,
                    leadingIconColor = LightBlue,
                    focusedIndicatorColor = LightBlue,
                    disabledIndicatorColor = GreyBlue
                ),
                modifier = Modifier
                    .requiredWidth(360.dp)
                    .height(50.dp)
                    .padding(
                        start = 10.dp,
                        end = 10.dp
                    )
                    .border(
                        BorderStroke(0.1.dp, White),
                        RoundedCornerShape(4.dp)
                    )
                    .constrainAs(serviceReminderTextField) {
                        top.linkTo(serviceReminderText.bottom, 10.dp)
                        start.linkTo(parent.start)
                    }
            )
        }

    }
}