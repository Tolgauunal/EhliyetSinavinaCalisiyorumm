package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.ui.testler.TestlerViewModel

@Composable
fun CloseAlert(onClose: (Boolean) -> Unit, onClick: () -> Unit) {
    AlertDialog(containerColor = colorResource(id = R.color.kapaliMavi),
        modifier = Modifier.padding(10.dp),
        onDismissRequest = {
            onClose(false)
        },
        title = {
            Text(text = "Testi Sonlandırmak İstediğinizden Emin Misiniz ?", color = Color.White)
        },
        dismissButton = {
            Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                    onClose(false)
                }) {
                Text("Hayır")
            }
        },
        confirmButton = {
            Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                    onClose(false)
                    onClick()
                }) {
                Text("Evet")
            }
        })
}
