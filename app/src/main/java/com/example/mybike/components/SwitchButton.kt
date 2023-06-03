package com.example.mybike.components

import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@Composable
fun SwitchButton(modifier: Modifier) {
    var switchOn by remember {
        mutableStateOf(true)
    }

    Switch(
        checked = switchOn,
        onCheckedChange = { switchOn_ ->
            switchOn = switchOn_
        },
        modifier = modifier,
        colors = SwitchDefaults.colors(
            checkedThumbColor = White,
            checkedTrackColor = LightBlue,
            checkedTrackAlpha = 1.0f,
            uncheckedTrackAlpha = 1.0f
        )
    )
}