package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.data.Konular

@Composable
fun CustomAlertDialog(alertDialog: MutableState<Boolean>, secilenKonu: Konular, navController: NavHostController) {
    val click = remember { mutableStateOf(false) }
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(true) }
            if (openDialog.value) {
                AlertDialog(onDismissRequest = {
                    openDialog.value = false
                    alertDialog.value = false
                }, title = {
                    Text(text = secilenKonu.name, textAlign = TextAlign.Center)
                }, confirmButton = {
                    Button(onClick = {
                        openDialog.value = false
                        alertDialog.value = false
                        click.value = true
                        navController.navigate("bilgiKartlari/${secilenKonu.name}")
                    }) {
                        Text("Bilgi Kartları")
                    }
                }, dismissButton = {
                    Button(onClick = {
                        openDialog.value = false
                        alertDialog.value = false
                        navController.navigate("konuAnlatimi/${secilenKonu.name}")
                    }) {
                        Text("Konu Anlatımı")
                    }
                })
            }
        }
    }
}
