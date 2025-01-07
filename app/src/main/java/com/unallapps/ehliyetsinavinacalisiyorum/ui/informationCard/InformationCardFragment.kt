package com.unallapps.ehliyetsinavinacalisiyorum.ui.informationCard

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.unallapps.ehliyetsinavinacalisiyorum.R

@Composable
fun InformationCardFragment(
    modifier: Modifier,
    informationCardViewModel: InformationCardViewModel = hiltViewModel()
) {
    val informationCardsInfo = informationCardViewModel.informationCardsInfo.collectAsState()
    val informationCardsSize = informationCardViewModel.informationCardsSize.collectAsState()
    var progress by remember { mutableIntStateOf(1) }

    Column(modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            informationCardsSize.value?.let { ProgressBar(progress = progress, size = it - 1) }
        }

        informationCardsInfo.value?.let {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(width = 1.dp, color = Color.Blue)
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Text(
                        text = it[progress].description,
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                    )
                    it[progress].details?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState()),
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
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
                            informationCardsSize.value?.let {
                                if (progress < it-1) {
                                    progress += 1
                                    println(progress)
                                    println(it)
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun ProgressBar(progress: Int, size: Float) {
    LinearProgressIndicator(progress = progress / size, modifier = Modifier.fillMaxWidth())
}