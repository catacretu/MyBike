package com.example.mybike.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybike.R
import com.example.mybike.ui.theme.Grey
import com.example.mybike.ui.theme.White

@Composable
fun MoreMenu(menuState: MutableState<Boolean>) {
    // a boolean variable which store the display menu state
    DropdownMenu(
        expanded = menuState.value,
        onDismissRequest = { menuState.value = false },
        modifier = Modifier
            .background(Grey)
    ) {

        DropdownMenuItem(
            onClick = {}, modifier = Modifier
                .width(90.dp)
                .height(30.dp)
        )
        {
            Icon(
                painterResource(
                    id = R.drawable.icon_edit
                ),
                contentDescription = "Edit Icon",
                tint = White,
                modifier = Modifier
                    .padding(end = 5.dp)
            )
            Text(
                text = "Edit", color = White,
                fontSize = 13.sp, fontWeight = FontWeight.SemiBold
            )
        }
        DropdownMenuItem(
            onClick = {}, modifier = Modifier
                .width(90.dp)
                .height(30.dp)
        ) {
            Icon(
                painterResource(
                    id = R.drawable.icon_delete
                ),
                contentDescription = "Delete Icon",
                tint = White,
                modifier = Modifier
                    .padding(end = 5.dp)
            )
            Text(
                text = "Delete", color = White,
                fontSize = 13.sp, fontWeight = FontWeight.SemiBold
            )
        }
    }
}