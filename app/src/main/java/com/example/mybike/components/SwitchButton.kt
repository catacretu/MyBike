package com.example.mybike.components

import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@Composable
fun SwitchButton(switchOn: MutableState<Boolean>,
                 modifier: Modifier
) {

    Switch(
        checked = switchOn.value,
        onCheckedChange = { switchOn_ ->
            switchOn.value = switchOn_
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