package com.unallapps.ehliyetsinavinacalisiyorum.testler

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.DatabaseDersler
import com.unallapps.ehliyetsinavinacalisiyorum.R

@Composable
fun Testler(paddingModifier: Modifier, navController: NavHostController) {
    val selectedDersItemIndex = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Testler")
        LazyVerticalGrid(columns = GridCells.Adaptive(128.dp), content = {
            items(DatabaseDersler.derslerList.size) { index ->
                val ders = DatabaseDersler.derslerList[index]
                if (selectedDersItemIndex.value == index) {
                    Card(modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .clickable { selectedDersItemIndex.value = index },
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.green))) {
                        Column(verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                            Image(painter = painterResource(id = ders.icon),
                                contentDescription = "",
                                alignment = Alignment.TopCenter)
                            Text(text = ders.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp))
                        }
                    }
                } else {
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                            .clickable { selectedDersItemIndex.value = index }
                            .clickable { selectedDersItemIndex.value = index },
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.kapaliMavi)),
                    ) {
                        Column(verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                            Image(painter = painterResource(id = ders.icon),
                                contentDescription = "",
                                alignment = Alignment.TopCenter)
                            Text (text = ders.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp))
                        }
                    }
                }
            }
        })
        Button(onClick = { navController.navigate("testEkrani") }) {
            Text(text = "Testi Başlat")
        }
    }
}
