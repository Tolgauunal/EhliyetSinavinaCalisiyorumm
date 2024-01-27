package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseDersler
import com.unallapps.ehliyetsinavinacalisiyorum.R

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Testler(paddingModifier: Modifier,
    navController: NavHostController,
    testlerNavViewModel: TestlerNavViewModel = hiltViewModel()) {
    val selectedDersItemIndex = remember { mutableIntStateOf(0) }
    val selectedDersItemText = remember { mutableStateOf("İlk Yardım") }
    Column(modifier = paddingModifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Testler")
        Spacer(modifier = Modifier.padding(8.dp))
        LazyVerticalGrid(columns = GridCells.Adaptive(128.dp), content = {
            items(DatabaseDersler.derslerList.size) { index ->
                val ders = DatabaseDersler.derslerList[index]
                if (selectedDersItemIndex.intValue == index) {
                    Card(modifier = Modifier
                        .clickable {
                            selectedDersItemIndex.intValue = index
                            selectedDersItemText.value = ders.name
                        }
                        .padding(4.dp)
                        .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.green))) {
                        Column(verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)) {
                            Image(painter = painterResource(id = ders.icon),
                                contentDescription = "",
                                alignment = Alignment.TopCenter,
                                modifier = Modifier.size(100.dp))
                            Text(text = ders.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp))
                        }
                    }
                } else {
                    Card(
                        modifier = Modifier
                            .clickable {
                                selectedDersItemIndex.intValue = index
                                selectedDersItemText.value = ders.name
                            }
                            .padding(4.dp)
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.kapaliMavi)),
                    ) {
                        Column(verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)) {
                            Image(painter = painterResource(id = ders.icon),
                                contentDescription = "",
                                alignment = Alignment.TopCenter,
                                modifier = Modifier.size(100.dp))
                            Text(text = ders.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp))
                        }
                    }
                }
            }
        })
        Spacer(modifier = Modifier.padding(8.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                    testlerNavViewModel.defaultTestItem(selectedDersItemText.value)
                    navController.navigate("testEkrani/${selectedDersItemText.value}")
                },
                modifier = Modifier.padding(16.dp).weight(0.5f)) {
                Text(text = "Baştan Başla", fontSize = 16.sp)
            }
            Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                    navController.navigate("testEkrani/${selectedDersItemText.value}")
                },
                modifier = Modifier.padding(16.dp).weight(0.5f)) {
                Text(text = "Devam Et", fontSize = 16.sp)
            }
        }
    }
}

