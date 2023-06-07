package com.example.mybike.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mybike.ui.theme.White

@Composable
fun Title(text: String) {
    Text(
        text,
        color = White,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    )
}