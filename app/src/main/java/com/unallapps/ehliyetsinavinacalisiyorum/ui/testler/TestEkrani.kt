package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseDersler
import com.unallapps.ehliyetsinavinacalisiyorum.data.Dersler
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestItemEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.TestlerState

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TestEkrani(paddingModifier: Modifier,
    dersAdi: String,
    testlerViewModel: TestlerViewModel = hiltViewModel(),
    navController: NavHostController) {
    testlerViewModel.testlerList(dersAdi)
    val soruKontrol = remember { mutableStateOf(true) }
    val uiDurum = remember { mutableStateOf(false) }
    val soruNumarasi = remember { mutableIntStateOf(0) }
    val soruSize = remember { mutableIntStateOf(0) }
    val testler = remember { mutableListOf<TestItemEntity>() }
    val testIcon = remember { mutableListOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d) }
    val soru = remember { mutableStateOf("") }
    val dogruCevap = remember { mutableStateOf("") }
    val dogruCevapIndex = remember { mutableIntStateOf(0) }
    val cevapKontrol = remember { mutableStateOf(false) }
    val secilenCevap = remember { mutableStateOf("") }
    val dogruCevapSayisi = remember { mutableIntStateOf(0) }
    val yanlisCevapSayisi = remember { mutableIntStateOf(0) }
    val soruImage = remember { mutableStateOf("") }
    var secilenDers = Dersler(0, "İlk Yardım", R.drawable.ilkyardim)
    for (dersler in DatabaseDersler.derslerList) {
        if (dersAdi == dersler.name) {
            secilenDers = DatabaseDersler.derslerList.get(index = dersler.id)
        }
    }
    if (soruKontrol.value) {
        LaunchedEffect(key1 = true) {
            testlerViewModel.stateFlow.collect {
                when (it) {
                    TestlerState.Idle -> {}
                    is TestlerState.result -> {
                        soruSize.intValue = it.testlerList.size
                        if (soruNumarasi.intValue != it.testlerList.size) {
                            val test = it.testlerList[soruNumarasi.intValue]
                            soru.value = test.content.toString()
                            testler.add(TestItemEntity(test.aTest.toString(), Color.White))
                            testler.add(TestItemEntity(test.bTest.toString(), Color.White))
                            testler.add(TestItemEntity(test.cTest.toString(), Color.White))
                            testler.add(TestItemEntity(test.dTest.toString(), Color.White))
                            dogruCevap.value = test.correct.toString()
                            soruImage.value = test.imageTest.toString()
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
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Image(painter = painterResource(secilenDers.icon),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp))
                Text(text = secilenDers.name, textAlign = TextAlign.Center)
                Image(painter = painterResource(id = R.drawable.baseline_close_24),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        navController.navigate("testler")
                    })
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Soru Sayısı ${soruNumarasi.intValue} / ${soruSize.intValue}",
                    modifier = Modifier.align(Alignment.CenterVertically))
                Column {
                    Row {
                        Image(painter = painterResource(id = R.drawable.dogru),
                            contentDescription = "",
                            modifier = Modifier.align(Alignment.CenterVertically))
                        Text(text = "Doğru Sayısı: ${dogruCevapSayisi.intValue}",
                            modifier = Modifier.align(Alignment.CenterVertically))
                    }
                    Row {
                        Image(painter = painterResource(id = R.drawable.wrong),
                            contentDescription = "",
                            modifier = Modifier.align(Alignment.CenterVertically))
                        Text(text = "Yanlış Sayısı: ${yanlisCevapSayisi.intValue}",
                            modifier = Modifier.align(Alignment.CenterVertically))
                    }
                }
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()) {
                Image(painter = rememberAsyncImagePainter(model = soruImage.value),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp))
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = soru.value)
            }
            Spacer(modifier = Modifier.padding(top = 50.dp))
            for (i in 0..3) {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        secilenCevap.value = testler[i].testString
                        soruKontrol.value = true
                        soruNumarasi.intValue = +1
                        if (cevapKontrol.value) {
                            testler[i].color = Color.Green
                        } else {
                            testler[i].color = Color.Red
                            testler[dogruCevapIndex.intValue].color = Color.Green
                        }
                    }) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = testler[i].color)) {
                        Image(painter = painterResource(testIcon[i]),
                            contentDescription = "",
                            modifier = Modifier.size(24.dp))
                        Text(text = testler[i].testString, modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }
        }
        for (dogruCevapItemIndex in 0..3) {
            if (testler[dogruCevapItemIndex].testString == dogruCevap.value) {
                dogruCevapIndex.intValue = dogruCevapItemIndex
            }
        }
        if (secilenCevap.value != "") {
            if (secilenCevap.value == dogruCevap.value) {
                dogruCevapSayisi.intValue = +1
                secilenCevap.value = ""
                cevapKontrol.value = true
                dogruCevap.value = ""
                testler.clear()
            } else {
                yanlisCevapSayisi.intValue = +1
                cevapKontrol.value = false
                secilenCevap.value = ""
                dogruCevap.value = ""
            }
        }
    }
}