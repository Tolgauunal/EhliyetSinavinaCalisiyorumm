package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.unallapps.ehliyetsinavinacalisiyorum.R

@Composable
fun FinishAlert(
    onfinishAlertDialog: (Boolean) -> Unit,
    onClick: (Boolean) -> Unit
) {
    AlertDialog(containerColor = colorResource(id = R.color.kapaliMavi),
        modifier = Modifier.padding(10.dp),
        onDismissRequest = {
            onfinishAlertDialog(false)
        },
        title = {
            Text(text = "Testlerimiz Bitti Baştan Başlamak İster Misiniz ?", color = Color.White)
        },
        confirmButton = {
            Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                    onClick(false)
                }) {
                Text("Evet")
            }
        },
        dismissButton = {
            Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                    onfinishAlertDialog(false)
                }) {
                Text("Hayır")
            }
        })
}