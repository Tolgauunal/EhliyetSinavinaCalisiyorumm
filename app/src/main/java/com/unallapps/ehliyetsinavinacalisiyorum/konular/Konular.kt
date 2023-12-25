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
import com.unallapps.ehliyetsinavinacalisiyorum.DatabaseDersler
import com.unallapps.ehliyetsinavinacalisiyorum.DatabaseKonular
import com.unallapps.ehliyetsinavinacalisiyorum.R

@Composable
fun Konular(paddingModifier: Modifier) {
    val derslerSelectedItem = remember { mutableStateOf(0) }
    Column(modifier = paddingModifier.padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Ders Seçiniz")
            Spacer(modifier = Modifier.padding(top = 10.dp))
            LazyRow(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                items(count = DatabaseDersler.derslerList.count(), itemContent = {
                    val ders = DatabaseDersler.derslerList[it]
                    if (derslerSelectedItem.value == it) {
                        Card(colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.kapaliMavi), contentColor = Color.White), border = BorderStroke(1.dp, color = colorResource(id = R.color.kapaliMavi)), elevation = CardDefaults.cardElevation(16.dp), shape = RoundedCornerShape(10.dp), modifier = Modifier.clickable { derslerSelectedItem.value = it }) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                Image(painter = painterResource(id = ders.icon), contentDescription = "")
                                Text(text = ders.name, modifier = Modifier.padding(10.dp), color = Color.White, fontSize = 16.sp)
                            }
                        }
                    } else {
                        Card(colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white), contentColor = Color.White), border = BorderStroke(1.dp, color = colorResource(id = R.color.kapaliMavi)), elevation = CardDefaults.cardElevation(16.dp), shape = RoundedCornerShape(10.dp), modifier = Modifier.clickable { derslerSelectedItem.value = it }) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                Image(painter = painterResource(id = ders.icon), contentDescription = "")
                                Text(text = ders.name, modifier = Modifier.padding(10.dp), color = colorResource(id = R.color.kapaliMavi))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(start = 0.dp, top = 10.dp, end = 10.dp, bottom = 10.dp))
                })
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Önerilen Konular")
            LazyColumn(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.Start) {
                items(count = DatabaseKonular.konularList.count(), itemContent = {
                    val konular = DatabaseKonular.konularList[it]
                    if (konular.id == derslerSelectedItem.value) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Card(colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.kapaliMavi)), shape = RoundedCornerShape(20.dp), modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier
                                        .fillMaxWidth()) {
                                    Image(painter = painterResource(id = konular.icon), contentDescription = "")
                                    Column (modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                        Text(text = konular.name, modifier = Modifier.padding(10.dp), color = Color.White)
                                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                            Image(painter = painterResource(id = konular.icon), contentDescription = "")
                                            Text(text = konular.name, modifier = Modifier.padding(10.dp), color = Color.White)
                                            Image(painter = painterResource(id = konular.icon), contentDescription = "")
                                            Text(text = konular.name, modifier = Modifier.padding(10.dp), color = Color.White)
                                        }
                                    }
                                }
                            }
                        }
                    }
                })
            }
        }
    }
}