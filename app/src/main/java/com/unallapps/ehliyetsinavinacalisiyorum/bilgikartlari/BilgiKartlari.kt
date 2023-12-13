package com.unallapps.ehliyetsinavinacalisiyorum.bilgikartlari

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unallapps.ehliyetsinavinacalisiyorum.R
import kotlinx.coroutines.launch

@Composable
fun BilgiKartlari(konuId: Int) {
    var progress by remember { mutableStateOf(0) }
    var bilgiKartiSize = 10f //Gelen veri ile eşleşecek size
    Column(modifier = Modifier.fillMaxSize()) {
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
            Text(text = "Tolga", modifier = Modifier.padding(40.dp))
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
fun ProgressBar(progress: Int, size: Float) {
    LinearProgressIndicator(progress = progress / size, modifier = Modifier.fillMaxWidth())
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun BilgiKartlariPreview() {
    BilgiKartlari(konuId = 1)
}