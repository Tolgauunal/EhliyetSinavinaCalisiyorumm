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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.unallapps.ehliyetsinavinacalisiyorum.R

@Composable
fun FinishAlert(
    onPopBack: (Boolean) -> Unit,
    onRestart: (Boolean) -> Unit
) {
    AlertDialog(
        containerColor = colorResource(id = R.color.kapaliMavi),
        modifier = Modifier.padding(10.dp),
        onDismissRequest = {
            onPopBack(false)
        },
        title = {
            Text(text = stringResource(R.string.test_Again), color = Color.White)
        },
        confirmButton = {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                    onRestart(false)
                }) {
                Text(stringResource(R.string.yes))
            }
        },
        dismissButton = {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                    onPopBack(false)
                }) {
                Text(stringResource(R.string.no))
            }
        }
    )
}