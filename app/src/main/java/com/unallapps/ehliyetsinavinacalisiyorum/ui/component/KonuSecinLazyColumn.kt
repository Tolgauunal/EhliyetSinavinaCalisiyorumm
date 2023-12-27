package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.unallapps.ehliyetsinavinacalisiyorum.DatabaseKonular
import com.unallapps.ehliyetsinavinacalisiyorum.R

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
                                modifier = Modifier.fillMaxWidth().padding(5.dp)) {
                                Image(painter = painterResource(id = konular.icon), contentDescription = "", modifier = Modifier.size(50.dp))
                                Column(modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(text = konular.name,
                                        modifier = Modifier.padding(10.dp),
                                        color = Color.White, maxLines = 1)
                                    Row(verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center) {
                                        Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
                                        Text(text = "Bilgi Kartları",
                                            modifier = Modifier.padding(10.dp),
                                            color = Color.White)
                                        Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
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
