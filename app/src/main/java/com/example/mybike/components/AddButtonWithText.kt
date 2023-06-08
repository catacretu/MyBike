package com.example.mybike.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybike.R
import com.example.mybike.ui.theme.White

@Composable
fun AddButtonWithText(text: String) {

    TextButton(onClick = {}) {
        Icon(
            painterResource(
                id = R.drawable.icon_add
            ),
            contentDescription = "Add Button",
            tint = White,
            modifier = Modifier.padding(start = 20.dp)
        )

        Text(
            text = text,
            color = White,
            fontSize = 17.sp,
            modifier = Modifier
                .padding(
                    start = 1.dp,
                    end = 10.dp
                )
        )
    }
}