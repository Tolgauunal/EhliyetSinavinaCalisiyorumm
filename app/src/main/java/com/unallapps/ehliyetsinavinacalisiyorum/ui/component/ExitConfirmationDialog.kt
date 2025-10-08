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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unallapps.ehliyetsinavinacalisiyorum.R

@Composable
fun ExitConfirmationDialog(
    onDismiss: (Boolean) -> Unit,
    onConfirmExit: () -> Unit
) {
    AlertDialog(
        containerColor = colorResource(id = R.color.kapaliMavi),
        modifier = Modifier.padding(10.dp),
        onDismissRequest = { onDismiss(false) },
        title = {
            Text(
                text = stringResource(R.string.test_Finish),
                color = Color.White
            )
        },
        dismissButton = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.altinsarisi)
                ),
                onClick = { onConfirmExit() }
            ) {
                Text(stringResource(R.string.yes))
            }
        },
        confirmButton = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.altinsarisi)
                ),
                onClick = { onDismiss(false) }
            ) {
                Text(stringResource(R.string.no))
            }
        }
    )
}

@Preview
@Composable
fun ExitConfirmationDialogPreview() {
    ExitConfirmationDialog(
        onDismiss = {},
        onConfirmExit = {}
    )
}