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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CloseAlert
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.FinishAlert

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TestEkrani(paddingModifier: Modifier,
    dersAdi: String,
    testlerViewModel: TestlerViewModel = hiltViewModel(),
    navController: NavHostController) {
    testlerViewModel.getTestIdData(dersAdi)
    val soruKontrol by testlerViewModel.soruKontrol.collectAsState()
    val progressShow by testlerViewModel.isProgressBar.collectAsState()
    val uiDurum by testlerViewModel.uiDurum.collectAsState()
    val showIcon by testlerViewModel.showIcon.collectAsState()
    val soruIndex by testlerViewModel.soruIndex.collectAsState()
    val testlerSize by testlerViewModel.testerSize.collectAsState()
    val soruSize = rememberSaveable { mutableIntStateOf(0) }
    val testler = rememberSaveable { mutableListOf<TestItemEntity>() }
    val soruNumarasi = rememberSaveable { mutableIntStateOf(1) }
    val testIcon = rememberSaveable { mutableListOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d) }
    val soru = rememberSaveable { mutableStateOf("") }
    val dogruCevap = rememberSaveable { mutableStateOf("") }
    val dogruCevapIndex = rememberSaveable { mutableIntStateOf(0) }
    val cevapKontrol = rememberSaveable { mutableStateOf(false) }
    val secilenCevap = rememberSaveable { mutableStateOf("") }
    val dogruCevapSayisi = rememberSaveable { mutableIntStateOf(0) }
    val yanlisCevapSayisi = rememberSaveable { mutableIntStateOf(0) }
    val soruImage = rememberSaveable { mutableStateOf("") }
    val closeTest = rememberSaveable { mutableStateOf(false) }
    val finishAlertDialog = rememberSaveable { mutableStateOf(false) }
    var secilenDers = Dersler(0, "İlk Yardım", R.drawable.ilkyardim)
    val enabled = rememberSaveable { mutableStateOf(true) }
    for (dersler in DatabaseDersler.derslerList) {
        if (dersAdi == dersler.name) {
            secilenDers = DatabaseDersler.derslerList.get(index = dersler.id)
        }
    }
    LaunchedEffect(key1 = true) {
        testlerViewModel.testIdData.collect {
            it?.let {
                dogruCevapSayisi.intValue = it.dogruSayisi
                yanlisCevapSayisi.intValue = it.yanlisSayisi
                if (it.testNum == 0) {
                    soruNumarasi.intValue = 1
                } else {
                    soruNumarasi.intValue = it.testNum
                }
                soruSize.intValue = it.soruSize
                testlerViewModel.firebaseTestList(dersAdi, it.testNum)
            }
        }
    }
    if (soruKontrol) {
        LaunchedEffect(key1 = true) {
            testlerViewModel.firebaseListState.collect {
                when (it) {
                    TestlerState.Idle -> {}
                    TestlerState.Loading -> {}
                    is TestlerState.result -> {
                        testlerViewModel.isProgressBar.value = false
                        if (soruSize.intValue == 0) {
                            soruSize.intValue = it.testlerList.size
                        }
                        if (soruIndex < testlerSize) {
                            val test = it.testlerList[soruIndex]
                            soru.value = test.content.toString()
                            testler.clear()
                            testlerViewModel.uiDurum.value = true
                            cevapKontrol.value = false
                            testler.add(TestItemEntity(test.aTest.toString(), R.color.acikmavi))
                            testler.add(TestItemEntity(test.bTest.toString(), R.color.acikmavi))
                            testler.add(TestItemEntity(test.cTest.toString(), R.color.acikmavi))
                            testler.add(TestItemEntity(test.dTest.toString(), R.color.acikmavi))
                            dogruCevap.value = test.correct.toString()
                            soruImage.value = test.imageTest.toString()
                            testlerViewModel.soruKontrol.value = false
                            for (dogruCevapItemIndex in 0..3) {
                                if (testler[dogruCevapItemIndex].testString == dogruCevap.value) {
                                    dogruCevapIndex.intValue = dogruCevapItemIndex
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    if (progressShow) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator()
        }
    }
    if (uiDurum) {
        Column(modifier = paddingModifier
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
                        closeTest.value = true
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
            if (soruImage.value.isEmpty()) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()) {
                    Image(painter = rememberAsyncImagePainter(model = soruImage.value),
                        contentDescription = "",
                        modifier = Modifier.size(height = 100.dp, width = 250.dp))
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = soru.value)
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            for (i in 0..3) {
                Spacer(modifier = Modifier.padding(10.dp))
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = enabled.value) {
                        secilenCevap.value = testler[i].testString
                        testlerViewModel.showIcon.value = true
                        enabled.value = false
                        if (secilenCevap.value != "") {
                            if (secilenCevap.value == dogruCevap.value) {
                                dogruCevapSayisi.intValue += 1
                                cevapKontrol.value = true
                            } else {
                                yanlisCevapSayisi.intValue += 1
                                cevapKontrol.value = false
                            }
                        }
                        if (cevapKontrol.value) {
                            testler[i].color = R.color.green
                        } else {
                            testler[i].color = R.color.red
                            testler[dogruCevapIndex.intValue].color = R.color.green
                        }
                    }) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = colorResource(id = testler[i].color))
                            .padding(10.dp)) {
                        Image(painter = painterResource(testIcon[i]),
                            contentDescription = "",
                            modifier = Modifier.size(24.dp))
                        Text(text = testler[i].testString, modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            if (showIcon) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()) {
                    if (soruNumarasi.intValue != soruSize.intValue) {
                        Image(painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                            contentDescription = "",
                            modifier = Modifier
                                .clickable {
                                    testlerViewModel.soruKontrol.value = true
                                    testlerViewModel.soruIndex.value += 1
                                    dogruCevap.value = ""
                                    enabled.value = true
                                    secilenCevap.value = ""
                                    testlerViewModel.showIcon.value = false
                                    soruNumarasi.intValue += 1
                                }
                                .size(36.dp))
                    } else {
                        finishAlertDialog.value = true

                    }
                }
            }
        }
        if (finishAlertDialog.value) {
            FinishAlert(onfinishAlertDialog = { finishAlertDialog.value = it }) {
                if (it) {
                    navController.navigate("testler")
                } else {
                    testlerViewModel.saveTestId(0, dersAdi, 0, 0, 0)
                    testlerViewModel.firebaseTestList(dersAdi = dersAdi, 0)
                    navController.navigate("testEkrani/${dersAdi}")
                }
            }
        }
        if (closeTest.value) {
            CloseAlert(onClose = { closeTest.value = it }) {
                testlerViewModel.saveTestId(soruNumarasi.intValue,
                    dersAdi,
                    dogruCevapSayisi.intValue,
                    yanlisCevapSayisi.intValue,
                    soruSize.intValue)
                navController.navigate("testler")
            }
        }
    }
}