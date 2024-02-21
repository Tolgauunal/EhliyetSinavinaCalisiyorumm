package com.unallapps.ehliyetsinavinacalisiyorum.ui.bilgikartlari

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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.BilgiKartlariEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.KonularState

@Composable
fun BilgiKartlari(konuName: String,
    paddingModifier: Modifier,
    bilgiKartlariViewModel: BilgiKartlariViewModel = hiltViewModel()) {
    bilgiKartlariViewModel.getKonu(konuAdi = konuName)
    val bilgiKartlariEntity = remember { mutableListOf<BilgiKartlariEntity>() }
    val uiKontrol = remember { mutableStateOf(false) }
    LaunchedEffect(key1 = true) {
        bilgiKartlariViewModel._stateFlow.collect {
            when (it) {
                KonularState.Idle -> {

                }
                KonularState.Loading -> {
                }
                is KonularState.Result -> {
                    for (text in it.konu) {
                        bilgiKartlariEntity.add(text)
                    }
                    uiKontrol.value = true
                }
            }
        }
    }
    if (uiKontrol.value) {
        GetUi(paddingModifier, bilgiKartlariEntity)
    }
}

@Composable
private fun GetUi(paddingModifier: Modifier, bilgiKartlariEntity: MutableList<BilgiKartlariEntity>) {
    var progress by remember { mutableIntStateOf(0) }
    val bilgiKartiSize by remember { mutableFloatStateOf(bilgiKartlariEntity.size.toFloat()) }
    Column(modifier = paddingModifier) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
            ProgressBar(progress = progress, size = bilgiKartiSize)
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .border(width = 1.dp, color = Color.Blue),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = rememberAsyncImagePainter(model = bilgiKartlariEntity[progress].image),
                contentDescription = "",
                modifier = Modifier.size(height = 100.dp, width = 250.dp))
            Text(text = bilgiKartlariEntity[progress].content.toString(), modifier = Modifier.padding(40.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Icon(painter = painterResource(id = R.drawable.baseline_keyboard_arrow_left_24),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        if (progress > 0) {
                            progress -= 1
                        }
                    })
                Icon(painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        if (progress < bilgiKartiSize.toInt()) {
                            progress += 1
                        }
                    })
            }
        }
    }
}

@Composable
private fun ProgressBar(progress: Int, size: Float) {
    LinearProgressIndicator(progress = progress / size, modifier = Modifier.fillMaxWidth())
}