package com.unallapps.ehliyetsinavinacalisiyorum.testler

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unallapps.ehliyetsinavinacalisiyorum.R

@Composable
fun TestEkrani() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.SpaceBetween) {
            Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
            Text(text = "Motor")
            Image(painter = painterResource(id = R.drawable.baseline_close_24), contentDescription = "")
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Soru Sayısı 1/20", modifier = Modifier.align(Alignment.CenterVertically))
            Column {
                Row {
                    Image(painter = painterResource(id = R.drawable.home),
                        contentDescription = "",
                        modifier = Modifier.align(Alignment.CenterVertically))
                    Text(text = "Doğru", modifier = Modifier.align(Alignment.CenterVertically))
                }
                Row {
                    Image(painter = painterResource(id = R.drawable.home),
                        contentDescription = "",
                        modifier = Modifier.align(Alignment.CenterVertically))
                    Text(text = "Doğru", modifier = Modifier.align(Alignment.CenterVertically))
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Çarpışma durumunda otomatik olarak şişerek sürücü ve yolcuların ölüm ve yaralanmalarını azaltan pasif güvenlik sisteminin adı nedir? ")
        }
        Spacer(modifier = Modifier.padding(top = 50.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(8.dp)) {
                    Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
                    Text(text = "ABS", modifier = Modifier.padding(start = 8.dp))
                }
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(8.dp)) {
                    Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
                    Text(text = "Start-Stop", modifier = Modifier.padding(start = 8.dp))
                }
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(8.dp)) {
                    Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
                    Text(text = "Hava yastığı", modifier = Modifier.padding(start = 8.dp))
                }
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(8.dp)) {
                    Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
                    Text(text = "Hafızalı koltuk", modifier = Modifier.padding(start = 8.dp))
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TestEkraniPreview() {
    TestEkrani()
}