package com.unallapps.ehliyetsinavinacalisiyorum.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unallapps.ehliyetsinavinacalisiyorum.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    val dersler = remember { mutableListOf("Deneme", "Deneme", "Deneme", "Deneme") }
    val searchText = remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Merhaba Misafir Kullanıcı!")
            Icon(painter = painterResource(id = R.drawable.home), contentDescription = "Profil Fotoğrafı")
        }
        Card(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)) {
                    Text(text = "Bütün Konulara Hızlı ve Kolay Yoldan Ulaşın")
                    OutlinedTextField(value = searchText.value,
                        onValueChange = { searchText.value = it },
                        label = { Text(text = "Konu Arayın", fontSize = 10.sp) })
                }
                Image(painter = painterResource(id = R.drawable.learningback),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .size(100.dp))
            }
        }
        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Ders Seçiniz")
            LazyRow(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                items(count = dersler.count(), itemContent = {
                    val ders = dersler[it]
                    Card(colors = CardDefaults.cardColors(Color.Blue), shape = CircleShape) {
                        Text(text = ders, modifier = Modifier.padding(10.dp), color = Color.White)
                    }
                })
            }
        }
        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Önerilen Konular")
            LazyColumn(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start) {
                items(count = dersler.count(), itemContent = {
                    val ders = dersler[it]
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Card(colors = CardDefaults.cardColors(Color.Blue),
                            shape = RectangleShape,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)) {
                            Text(text = ders, modifier = Modifier.padding(10.dp), color = Color.White)
                        }
                    }
                })
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomePreview() {
    Home()
}