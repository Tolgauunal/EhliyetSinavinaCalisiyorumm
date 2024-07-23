package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.Subject

@Composable
fun CustomAlertDialog(
    selectedSubject: Subject,
    onAlertDialogChange: (Boolean) -> Unit,
    onClickBilgiKartlari: (String) -> Unit,
    onClickKonuAnlatimi: (String) -> Unit
) {
    val click = remember { mutableStateOf(false) }
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(true) }
            if (openDialog.value) {
                AlertDialog(containerColor = colorResource(id = R.color.kapaliMavi),
                    modifier = Modifier.padding(10.dp),
                    onDismissRequest = {
                        openDialog.value = false
                        onAlertDialogChange(false)
                    },
                    title = {
                        Text(
                            text = selectedSubject.name,
                            color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp, start = 10.dp),
                            textAlign = TextAlign.Center
                        )
                    },
                    confirmButton = {
                        Button(colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(
                                id = R.color.altinsarisi
                            )
                        ),
                            onClick = {
                                openDialog.value = false
                                onAlertDialogChange(false)
                                click.value = true
                                onClickBilgiKartlari(selectedSubject.name)
                            }) {
                            Text(
                                "Bilgi Kartları",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    },
                    dismissButton = {
                        Button(colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(
                                id = R.color.altinsarisi
                            )
                        ),
                            onClick = {
                                openDialog.value = false
                                onAlertDialogChange(false)
                                onClickKonuAnlatimi(selectedSubject.name)
                            }) {
                            Text(
                                "Konu Anlatımı",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    })
            }
        }
    }
}
