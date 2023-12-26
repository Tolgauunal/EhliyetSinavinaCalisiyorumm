package com.unallapps.ehliyetsinavinacalisiyorum.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.unallapps.ehliyetsinavinacalisiyorum.DatabaseDersler
import com.unallapps.ehliyetsinavinacalisiyorum.DatabaseKonular
import com.unallapps.ehliyetsinavinacalisiyorum.Dersler
import com.unallapps.ehliyetsinavinacalisiyorum.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Home(paddingModifier: Modifier, navController: NavHostController) {
    val derslerSelectedItem = remember { mutableStateOf(0) }
    val searchText = remember { mutableStateOf("") }
    val alertDialog = remember { mutableStateOf(false) }
    val selectedKonu = remember { mutableStateOf(DatabaseKonular.konularList[0]) }
    Column(modifier = paddingModifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Merhaba Misafir Kullanıcı!", color = colorResource(id = R.color.kapaliMavi))
            Icon(painter = painterResource(id = R.drawable.home), contentDescription = "Profil Fotoğrafı")
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
                    OutlinedTextField(value = searchText.value,
                        onValueChange = { searchText.value = it },
                        colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White,
                            textColor = Color.White,
                            disabledTextColor = Color.Black,
                            disabledBorderColor = colorResource(id = R.color.acikmavi),
                            focusedLabelColor = Color.White,
                            focusedBorderColor = colorResource(id = R.color.acikmavi)),
                        label = { Text(text = "Konu Arayın", fontSize = 10.sp) },
                        maxLines = 1)
                }
                Image(painter = painterResource(id = R.drawable.learningback),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .size(100.dp))
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        DersSecinLazyColumn(derslerSelectedItem = derslerSelectedItem)
        Spacer(modifier = Modifier.padding(5.dp))
        KonuSecinLazyColumn(derslerSelectedItem = derslerSelectedItem, alertDialog = alertDialog)
        if (alertDialog.value) {
            AlertDialogSample(alertDialog, selectedKonu.value, navController)
        }
    }
}

@Composable
fun DersSecinLazyColumn(derslerSelectedItem: MutableState<Int>) {
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Ders Seçiniz")
        Spacer(modifier = Modifier.padding(top = 10.dp))
        LazyRow(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            items(count = DatabaseDersler.derslerList.count(), itemContent = {
                val ders = DatabaseDersler.derslerList[it]
                if (derslerSelectedItem.value == it) {
                    Card(colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.kapaliMavi),
                        contentColor = Color.White),
                        border = BorderStroke(1.dp, color = colorResource(id = R.color.kapaliMavi)),
                        elevation = CardDefaults.cardElevation(16.dp),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.clickable { derslerSelectedItem.value = it }) {
                        Row(verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(5.dp)) {
                            Image(painter = painterResource(id = ders.icon),
                                contentDescription = "",
                                modifier = Modifier.size(30.dp))
                            Text(text = ders.name,
                                modifier = Modifier.padding(10.dp),
                                color = Color.White,
                                fontSize = 16.sp)
                        }
                    }
                } else {
                    Card(colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white),
                        contentColor = Color.White),
                        border = BorderStroke(1.dp, color = colorResource(id = R.color.kapaliMavi)),
                        elevation = CardDefaults.cardElevation(16.dp),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.clickable { derslerSelectedItem.value = it }) {
                        Row(verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(5.dp)) {
                            Image(painter = painterResource(id = ders.icon),
                                contentDescription = "",
                                modifier = Modifier.size(30.dp))
                            Text(text = ders.name,
                                modifier = Modifier.padding(10.dp),
                                color = colorResource(id = R.color.kapaliMavi))
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(start = 0.dp, top = 10.dp, end = 10.dp, bottom = 10.dp))
            })
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KonuSecinLazyColumn(derslerSelectedItem: MutableState<Int>,alertDialog: MutableState<Boolean>){
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Önerilen Konular")
        LazyColumn(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start) {
            items(count = DatabaseKonular.konularList.count(), itemContent = {
                val konular = DatabaseKonular.konularList[it]
                if (konular.id == derslerSelectedItem.value) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Card(colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.kapaliMavi)),
                            shape = RoundedCornerShape(20.dp),
                            onClick = {
                                alertDialog.value = true
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                                modifier = Modifier.fillMaxWidth()) {
                                Image(painter = painterResource(id = konular.icon), contentDescription = "")
                                Column(modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(text = konular.name,
                                        modifier = Modifier.padding(10.dp),
                                        color = Color.White, maxLines = 1)
                                    Row(verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center) {
                                        Image(painter = painterResource(id = konular.icon), contentDescription = "")
                                        Text(text = "Bilgi Kartları",
                                            modifier = Modifier.padding(10.dp),
                                            color = Color.White)
                                        Image(painter = painterResource(id = konular.icon), contentDescription = "")
                                        Text(text = "Konu Anlatım",
                                            modifier = Modifier.padding(10.dp),
                                            color = Color.White)
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

@Composable
fun AlertDialogSample(alertDialog: MutableState<Boolean>, secilenKonu: Dersler, navController: NavHostController) {
    val click = remember { mutableStateOf(false) }
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(true) }
            if (openDialog.value) {
                AlertDialog(onDismissRequest = {
                    openDialog.value = false
                    alertDialog.value = false
                }, title = {
                    Text(text = secilenKonu.name, textAlign = TextAlign.Center)
                }, confirmButton = {
                    Button(onClick = {
                        openDialog.value = false
                        alertDialog.value = false
                        click.value = true
                        navController.navigate("bilgiKartlari")
                    }) {
                        Text("Bilgi Kartları")
                    }
                }, dismissButton = {
                    Button(onClick = {
                        openDialog.value = false
                        alertDialog.value = false
                        navController.navigate("konuAnlatimi")
                    }) {
                        Text("Konu Anlatımı")
                    }
                })
            }
        }
    }
}
