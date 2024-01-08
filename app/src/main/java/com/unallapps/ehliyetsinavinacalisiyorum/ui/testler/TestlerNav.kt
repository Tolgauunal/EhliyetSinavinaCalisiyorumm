package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.TestlerState

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Testler(paddingModifier: Modifier, navController: NavHostController, testlerNavViewModel: TestlerNavViewModel = hiltViewModel()) {
    val selectedDersItemIndex = remember { mutableStateOf(0) }
    Column(modifier = paddingModifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Testler")
        Spacer(modifier = Modifier.padding(8.dp))
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
                            .padding(4.dp)
                            .fillMaxWidth()
                            .clickable { selectedDersItemIndex.value = index }
                            .clickable { selectedDersItemIndex.value = index },
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
        Button(onClick = {  navController.navigate("testEkrani") }, modifier = Modifier.padding(16.dp)) {
            Text(text = "Testi Başlat", fontSize = 16.sp)
        }
    }
}
