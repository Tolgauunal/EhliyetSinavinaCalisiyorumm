package com.unallapps.ehliyetsinavinacalisiyorum.konular

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.DatabaseDersler
import com.unallapps.ehliyetsinavinacalisiyorum.DatabaseKonular
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.home.AlertDialogSample
import com.unallapps.ehliyetsinavinacalisiyorum.home.DersSecinLazyColumn
import com.unallapps.ehliyetsinavinacalisiyorum.home.KonuSecinLazyColumn

@Composable
fun Konular(paddingModifier: Modifier, navController: NavHostController) {
    val derslerSelectedItem = remember { mutableStateOf(0) }
    val selectedKonu = remember { mutableStateOf(DatabaseKonular.konularList[0]) }
    val alertDialog = remember { mutableStateOf(false) }
    Column(modifier = paddingModifier.padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        DersSecinLazyColumn(derslerSelectedItem = derslerSelectedItem)
        Spacer(modifier = Modifier.padding(5.dp))
        KonuSecinLazyColumn(derslerSelectedItem = derslerSelectedItem, alertDialog = alertDialog)
        if (alertDialog.value){
            AlertDialogSample(alertDialog = alertDialog, secilenKonu = selectedKonu.value, navController = navController)
        }
    }
}