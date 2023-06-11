package com.example.mybike.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mybike.ui.theme.White
import com.example.mybike.ui.theme.bikeColors

@Composable
fun ColorsList(
    modifier: Modifier,
    selectedColor: MutableState<Color>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
    ) {
        items(bikeColors.size) { index ->
            Button(
                onClick = { selectedColor.value = bikeColors.keys.elementAt(index) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = bikeColors.keys.elementAt(index)
                ),
                shape = CircleShape,
                modifier = Modifier.size(25.dp)
            ) {
                Text(text = "Hello")
            }
        }
    }
}