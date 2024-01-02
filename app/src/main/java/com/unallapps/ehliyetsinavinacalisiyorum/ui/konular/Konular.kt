package com.unallapps.ehliyetsinavinacalisiyorum.ui.konular

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseKonular
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CustomAlertDialog
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.DersSecinLazyRow
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.KonuSecinLazyColumn

@Composable
fun Konular(paddingModifier: Modifier, navController: NavHostController) {
    val derslerSelectedItem = remember { mutableStateOf(0) }
    val selectedKonu = remember { mutableStateOf(DatabaseKonular.konularList[0]) }
    val alertDialog = remember { mutableStateOf(false) }
    Column(modifier = paddingModifier.padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        DersSecinLazyRow(derslerSelectedItem = derslerSelectedItem)
        Spacer(modifier = Modifier.padding(5.dp))
        KonuSecinLazyColumn(derslerSelectedItem = derslerSelectedItem, alertDialog = alertDialog)
        if (alertDialog.value){
            CustomAlertDialog(alertDialog = alertDialog, secilenKonu = selectedKonu.value, navController = navController)
        }
    }
}