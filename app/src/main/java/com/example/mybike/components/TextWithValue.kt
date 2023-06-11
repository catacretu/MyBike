package com.example.mybike.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.mybike.ui.theme.White

@Composable
fun TextWithValue(
    label: String,
    value: String,
    fontSize: TextUnit = 17.sp,
    fontWeight: FontWeight = FontWeight.SemiBold,
    modifier: Modifier
) {
    Row(modifier = modifier) {

        Text(
            text = label, color = White,
            fontSize = fontSize
        )
        Text(
            text = value, color = White,
            fontSize = fontSize, fontWeight = fontWeight
        )
    }
}