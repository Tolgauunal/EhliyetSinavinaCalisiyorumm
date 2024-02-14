package com.unallapps.ehliyetsinavinacalisiyorum.ui.konular

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CustomAlertDialog
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.DersSecinLazyRow
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.KonuSecinLazyColumn

@Composable
fun Konular(paddingModifier: Modifier,
    navController: NavHostController,
    konularViewModel: KonularViewModel = hiltViewModel()) {
    val derslerSelectedItem = konularViewModel.derslerSelectedItem.collectAsState()
    val selectedKonu = konularViewModel.selectedKonu.collectAsState()
    val alertDialog = konularViewModel.alertDialog.collectAsState()

    Column(modifier = paddingModifier.padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        DersSecinLazyRow(derslerSelectedItem = derslerSelectedItem.value) {
            konularViewModel.derslerSelectedItem.value = it
        }
        Spacer(modifier = Modifier.padding(5.dp))
        KonuSecinLazyColumn(derslerSelectedItem = derslerSelectedItem.value,
            controller = false,
            onSelectedKonu = { konularViewModel.selectedKonu.value = it },
            onAlertDialog = { konularViewModel.alertDialog.value = it })
        if (alertDialog.value) {
            CustomAlertDialog(alertDialog = alertDialog.value,
                secilenKonu = selectedKonu.value,
                onAlertDialogChange = { konularViewModel.alertDialog.value = it }) {
                navController.navigate("konuAnlatimi/${it}")
            }
        }
    }
}