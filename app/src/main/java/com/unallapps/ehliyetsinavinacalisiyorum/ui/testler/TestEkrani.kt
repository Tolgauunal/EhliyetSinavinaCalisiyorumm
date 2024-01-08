package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.TestlerState


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TestEkrani(paddingModifier: Modifier, testlerViewModel: TestlerViewModel = hiltViewModel()) {
    testlerViewModel.testlerList()
    val soruKontrol = remember { mutableStateOf(true) }
    val uiDurum = remember { mutableStateOf(false) }
    val soruNumarasi = remember { mutableStateOf(0) }
    val soruSize = remember { mutableStateOf(0) }
    val aTest = remember { mutableStateOf("") }
    val bTest = remember { mutableStateOf("") }
    val cTest = remember { mutableStateOf("") }
    val dTest = remember { mutableStateOf("") }
    val soru = remember { mutableStateOf("") }
    val dogruCevap = remember { mutableStateOf("") }
    val secilenCevap = remember { mutableStateOf("") }
    val dogruCevapSayisi = remember { mutableStateOf(0) }
    val yanlisCevapSayisi = remember { mutableStateOf(0) }

    if (soruKontrol.value) {
        LaunchedEffect(key1 = true) {
            testlerViewModel.stateFlow.collect {
                when (it) {
                    TestlerState.Idle -> {}
                    is TestlerState.result -> {
                        soruSize.value = it.testlerList.size
                        if (soruNumarasi.value != it.testlerList.size) {
                            val test = it.testlerList[soruNumarasi.value]
                            soru.value = test.content.toString()
                            aTest.value = test.aTest.toString()
                            bTest.value = test.bTest.toString()
                            cTest.value = test.cTest.toString()
                            dTest.value = test.dTest.toString()
                            dogruCevap.value = test.correct.toString()
                            soruKontrol.value = false
                            uiDurum.value = true
                        }
                    }
                }
            }
        }
    }
    if (uiDurum.value) {
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
                Text(text = "Soru Sayısı ${soruNumarasi.value + 1} / ${soruSize.value}",
                    modifier = Modifier.align(Alignment.CenterVertically))
                Column {
                    Row {
                        Image(painter = painterResource(id = R.drawable.home),
                            contentDescription = "",
                            modifier = Modifier.align(Alignment.CenterVertically))
                        Text(text = "Doğru Sayısı: ${dogruCevapSayisi.value}", modifier = Modifier.align(Alignment.CenterVertically))
                    }
                    Row {
                        Image(painter = painterResource(id = R.drawable.home),
                            contentDescription = "",
                            modifier = Modifier.align(Alignment.CenterVertically))
                        Text(text = "Yanlış Sayısı: ${yanlisCevapSayisi.value}", modifier = Modifier.align(Alignment.CenterVertically))
                    }
                }
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = soru.value)
            }
            Spacer(modifier = Modifier.padding(top = 50.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        secilenCevap.value = aTest.value
                        soruKontrol.value = true
                        soruNumarasi.value = +1
                    }) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()) {
                        Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
                        Text(text = aTest.value, modifier = Modifier.padding(start = 8.dp))
                    }
                }
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        secilenCevap.value = bTest.value
                        soruKontrol.value = true
                        soruNumarasi.value = +1
                    }) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()) {
                        Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
                        Text(text = bTest.value, modifier = Modifier.padding(start = 8.dp))
                    }
                }
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        secilenCevap.value = cTest.value
                        soruKontrol.value = true
                        soruNumarasi.value = +1
                    }) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()) {
                        Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
                        Text(text = cTest.value, modifier = Modifier.padding(start = 8.dp))
                    }
                }
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        secilenCevap.value = dTest.value
                        soruKontrol.value = true
                        soruNumarasi.value = +1
                    }) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()) {
                        Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
                        Text(text = dTest.value, modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }
        }
    }
    if (secilenCevap.value != "") {
        if (secilenCevap.value == dogruCevap.value) {
            dogruCevapSayisi.value = +1
            secilenCevap.value = ""
            dogruCevap.value = ""
        } else {
            yanlisCevapSayisi.value = +1
            secilenCevap.value = ""
            dogruCevap.value = ""
        }
    }
}
