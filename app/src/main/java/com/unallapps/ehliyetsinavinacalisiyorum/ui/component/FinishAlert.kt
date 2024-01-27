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
fun FinishAlert(navController: NavHostController,
    testlerViewModel: TestlerViewModel,
    dersAdi: String,
    finishAlertDialog: MutableState<Boolean>) {
    AlertDialog(containerColor = colorResource(id = R.color.kapaliMavi),
        modifier = Modifier.padding(10.dp),
        onDismissRequest = {
            finishAlertDialog.value = false
        },
        title = {
            Text(text = "Testlerimiz Bitti Baştan Başlamak İster Misiniz ?", color = Color.White)
        },
        confirmButton = {
            Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                finishAlertDialog.value = false
                testlerViewModel.saveTestId(0, dersAdi, 0, 0, 0)
                testlerViewModel.firebaseTestList(dersAdi = dersAdi, 0)
                navController.navigate("testEkrani/${dersAdi}")
            }) {
                Text("Evet")
            }
        },
        dismissButton = {
            Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                finishAlertDialog.value = false
                testlerViewModel.navigate(navController = navController)
            }) {
                Text("Hayır")
            }
        })
}