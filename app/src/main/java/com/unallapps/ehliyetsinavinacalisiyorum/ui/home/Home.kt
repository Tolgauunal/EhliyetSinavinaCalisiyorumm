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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.DersSecinLazyRow
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.KonuSecinLazyColumn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(paddingModifier: Modifier, navController: NavHostController, homeViewModel: HomeViewModel = hiltViewModel()) {
    val derslerSelectedItem = remember { mutableIntStateOf(0) }
    val searchText = remember { mutableStateOf("") }
    val nameStateText = remember { mutableStateOf("") }
    homeViewModel.getUserIno()
    CoroutineScope(Dispatchers.Main).launch {
        homeViewModel.userInfo.collect {
            nameStateText.value = it.userName
        }
    }
    Column(modifier = paddingModifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = nameStateText.value, color = colorResource(id = R.color.kapaliMavi), fontSize = 16.sp)
            if (homeViewModel.userInfo.value.userPhoto != null) {
                val userPhoto = homeViewModel.userInfo.value.userPhoto
                val bitmap = BitmapFactory.decodeByteArray(userPhoto, 0, userPhoto!!.size)
                Image(bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop)
            } else {
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
                    OutlinedTextField(
                        value = searchText.value,
                        onValueChange = { searchText.value = it },
                        colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White,
                            textColor = Color.White,
                            disabledTextColor = Color.Black,
                            disabledBorderColor = colorResource(id = R.color.acikmavi),
                            focusedLabelColor = Color.White,
                            focusedBorderColor = colorResource(id = R.color.acikmavi)),
                        label = { Text(text = "Konu Arayın", fontSize = 10.sp) },
                        maxLines = 1,
                    )
                }
                Image(painter = painterResource(id = R.drawable.learningback),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .size(100.dp))
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        DersSecinLazyRow(derslerSelectedItem = derslerSelectedItem)
        Spacer(modifier = Modifier.padding(5.dp))
        KonuSecinLazyColumn(derslerSelectedItem = derslerSelectedItem, navController)
    }
}
