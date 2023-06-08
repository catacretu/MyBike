package com.example.mybike.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mybike.ui.theme.GreyBlue
import com.example.mybike.ui.theme.LightBlue
import com.example.mybike.ui.theme.OceanBlueColor
import com.example.mybike.ui.theme.White

@Composable
fun DeleteAlertDialog(openDialog: MutableState<Boolean>) {
//    var openDialog by remember { mutableStateOf(true)  }

    if (openDialog.value) {

        AlertDialog(
            modifier = Modifier.height(135.dp),
            onDismissRequest = {
                openDialog.value = false
            },
            backgroundColor = GreyBlue,
            title = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Nukeproof Scout 290\r\nwill be deleted.",
                        color = White,
                        textAlign = TextAlign.Center,
                    )


                }
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 25.dp,
                        alignment = Alignment.CenterHorizontally
                    )
                ) {

                    TextButton(
                        onClick = {
                            openDialog.value = false
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = GreyBlue,
                            contentColor = LightBlue
                        ),
                    ) {
                        Text("Cancel", fontWeight = FontWeight.Normal)

                    }

                    Button(
                        onClick = {
                            openDialog.value = false
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = OceanBlueColor,
                            contentColor = White
                        ),
                        modifier = Modifier
                            .width(120.dp)
                    ) {
                        Text("Delete", fontWeight = FontWeight.Normal)
                    }
                }
            })
    }
}
