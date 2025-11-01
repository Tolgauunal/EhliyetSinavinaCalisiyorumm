package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.Subject
import com.unallapps.ehliyetsinavinacalisiyorum.data.enums.InformationActionType

@Composable
fun InformationCardDialog(
    selectedSubject: Subject,
    onAlertDialogChange: (Boolean) -> Unit,
    onClickAction: (actionType: InformationActionType, subjectName: String) -> Unit
) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            containerColor = colorResource(id = R.color.kapaliMavi),
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
                        .padding(horizontal = 10.dp),
                    textAlign = TextAlign.Center
                )
            },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.altinsarisi)
                    ),
                    onClick = {
                        openDialog.value = false
                        onAlertDialogChange(false)
                        onClickAction(InformationActionType.InformationCard, selectedSubject.name)
                    }
                ) {
                    Text(
                        "Bilgi Kartları",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            },
            dismissButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.altinsarisi)
                    ),
                    onClick = {
                        openDialog.value = false
                        onAlertDialogChange(false)
                        onClickAction(InformationActionType.SubjectScreen, selectedSubject.name)
                    }
                ) {
                    Text(
                        "Konu Anlatımı",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun CustomAlertDialogPreview() {
    InformationCardDialog(
        selectedSubject = Subject(
            id = 1,
            name = "Genel İlk Yardım Bilgileri",
            icon = R.drawable.ilkyardim
        ),
        onAlertDialogChange = {},
        onClickAction = { action, name -> }
    )
}
