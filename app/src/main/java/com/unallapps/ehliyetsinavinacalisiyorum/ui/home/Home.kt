package com.unallapps.ehliyetsinavinacalisiyorum.ui.home

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.AutoComplete
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CustomAlertDialog
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.DersSecinLazyRow
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.KonuSecinLazyColumn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
@Composable
fun Home(paddingModifier: Modifier, navController: NavHostController, homeViewModel: HomeViewModel = hiltViewModel()) {
    val nameStateText = homeViewModel.nameStateText.collectAsState()
    val derslerSelectedItem = homeViewModel.derslerSelectedItem.collectAsState()
    val selectedKonu = homeViewModel.selectedKonu.collectAsState()
    val alertDialog = homeViewModel.alertDialog.collectAsState()

    homeViewModel.getUserInfo()
    getProfileInfo(homeViewModel, nameStateText.value)
    Column(modifier = paddingModifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = nameStateText.value, color = colorResource(id = R.color.kapaliMavi), fontSize = 16.sp)
            homeViewModel.userInfo.value.userPhoto?.let {
                val bitmap = BitmapFactory.decodeByteArray(homeViewModel.userInfo.value.userPhoto,
                    0,
                    homeViewModel.userInfo.value.userPhoto!!.size)
                Image(bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop)
            } ?: run {
                Image(painter = painterResource(id = R.drawable.person),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(24.dp))
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Card(modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.kapaliMavi))) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)) {
                    Text(text = "Bütün Konulara Hızlı ve Kolay Yoldan Ulaşın",
                        color = colorResource(id = R.color.white),
                        textAlign = TextAlign.Center)
                    AutoComplete() {
                        navController.navigate("konuAnlatimi/${it}")
                    }
                }
                Image(painter = painterResource(id = R.drawable.learningback),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .size(100.dp))
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        DersSecinLazyRow(derslerSelectedItem = derslerSelectedItem.value) {
            homeViewModel.derslerSelectedItem.value = it
        }
        Spacer(modifier = Modifier.padding(5.dp))
        KonuSecinLazyColumn(derslerSelectedItem = derslerSelectedItem.value,
            controller = true,
            onSelectedKonu = { homeViewModel.selectedKonu.value = it },
            onAlertDialog = { homeViewModel.alertDialog.value = it })
    }
    if (alertDialog.value) {
        CustomAlertDialog(alertDialog.value,
            selectedKonu.value,
            onAlertDialogChange = { homeViewModel.alertDialog.value = it },
            onClickBilgiKartlari = { navController.navigate("bilgiKartlari/${it}") }) {
            navController.navigate("konuAnlatimi/${it}")
        }
    }
}

private fun getProfileInfo(homeViewModel: HomeViewModel, nameStateText: String) {
    CoroutineScope(Dispatchers.Main).launch {
        homeViewModel.userInfo.collect {
            homeViewModel.nameStateText.value = nameStateText
        }
    }
}
