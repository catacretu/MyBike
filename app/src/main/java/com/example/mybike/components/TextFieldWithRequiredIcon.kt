package com.example.mybike.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mybike.R
import com.example.mybike.ui.theme.Beige
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@Composable
fun TextFieldWithRequiredIcon(
    fieldName: String,
    fieldValue: String,
    withIcon: Boolean = true,
    measureUnit: String = "",
    modifierLayout: Modifier,
    modifierTextField: Modifier
) {
    ConstraintLayout(
        modifier = modifierLayout

    ) {
        val (textLabel,
            iconRequired,
            textField) = createRefs()

        val customTextSelectionColors = TextSelectionColors(
            handleColor = LightBlue,
            backgroundColor = LightBlue
        )

        Text(text = fieldName,
            fontSize = 12.sp,
            color = White,
            modifier = Modifier
                .padding(start = 1.dp)
                .constrainAs(textLabel) {
                    top.linkTo(parent.top, 15.dp)
                    start.linkTo(parent.start, 10.dp)
                }
        )
        if (withIcon) {
            Icon(
                painterResource(
                    id = R.drawable.icon_required
                ),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier
                    .constrainAs(iconRequired) {
                        top.linkTo(parent.top, 15.dp)
                        start.linkTo(textLabel.end, 1.dp)
                    })
        }

        CompositionLocalProvider(
            LocalTextSelectionColors provides customTextSelectionColors
        ) {
            TextField(
                value = fieldValue,
                onValueChange = {},
                textStyle = TextStyle.Default.copy(fontSize = 14.sp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = GreyBlue,
                    textColor = White,
                    cursorColor = LightBlue,
                    trailingIconColor = Beige,
                    focusedIndicatorColor = LightBlue,
                    disabledIndicatorColor = GreyBlue
                ),
                trailingIcon = {
                    Text(
                        measureUnit,
                        modifier =
                        Modifier
                            .padding(end = 10.dp),
                        fontSize = 14.sp
                    )
                },

                modifier = modifierTextField
                    .height(50.dp)
                    .padding(
                        start = 10.dp,
                        end = 10.dp
                    )
                    .border(
                        BorderStroke(0.1.dp, White),
                        RoundedCornerShape(4.dp)
                    )
                    .constrainAs(textField) {
                        top.linkTo(textLabel.bottom, 5.dp)
                        start.linkTo(parent.start)
                    }
            )
        }

    }
}