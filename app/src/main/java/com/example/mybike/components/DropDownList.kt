package com.example.mybike.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.White

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownList(
    listOfItems: Array<String>,
    modifierDropDownList: Modifier = Modifier,
    modifierTextField: Modifier = Modifier
) {
//    val listItems = arrayOf("KM", "Mi")

    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    // remember the selected item
    var selectedItem by remember {
        mutableStateOf(listOfItems[0])
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = modifierDropDownList
    ) {

        TextField(
            value = selectedItem,
            onValueChange = {},
            textStyle = TextStyle.Default.copy(fontSize = 14.sp),
            readOnly = true,
            modifier = modifierTextField,
            shape = RoundedCornerShape(4.dp),

            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded,
                )
            },
            colors = ExposedDropdownMenuDefaults
                .textFieldColors(
                    backgroundColor = GreyBlue,
                    textColor = White,
                    trailingIconColor = Color(0xFFF4F4F4),
                    focusedTrailingIconColor = LightBlue,
                    disabledTrailingIconColor = GreyBlue,
                    focusedIndicatorColor = LightBlue,
                    unfocusedIndicatorColor = GreyBlue
                )
        )
        // menu
        ExposedDropdownMenu(
            expanded = expanded,
            modifier = Modifier
                .background(color = GreyBlue),
            onDismissRequest = { expanded = false }
        ) {

            listOfItems.forEach { selectedOption ->
                DropdownMenuItem(onClick = {
                    selectedItem = selectedOption
                    expanded = false
                }) {
                    Text(text = selectedOption, color = White)
                }
            }
        }
    }
}
