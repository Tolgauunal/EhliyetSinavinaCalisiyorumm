package com.unallapps.ehliyetsinavinacalisiyorum.ui.informationCard

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    viewModel: InformationCardViewModel = hiltViewModel()
) {
    val informationCardsInfo by viewModel.informationCardsInfo.collectAsState()
    val informationCardsSize by viewModel.informationCardsSize.collectAsState()
    val progressBarCount by viewModel.progressBarCount.collectAsState()
    val forwardIconShow by viewModel.forwardIconShow.collectAsState()
    val backIconShow by viewModel.backIconShow.collectAsState()

    Column(modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            informationCardsSize?.let {
                ProgressBar(progress = progressBarCount, size = it - 1)
            }
        }

        informationCardsInfo?.let {
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
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                        text = it[progressBarCount].description
                    )
                    it[progressBarCount].details?.let {
                        Text(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState()),
                            text = it
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    if (backIconShow) {
                        Icon(
                            modifier = Modifier
                                .clickable {
                                    viewModel.setProgressBarCount(progressBarCount - 1)
                                }
                                .align(Alignment.TopStart),
                            painter = painterResource(id = R.drawable.baseline_keyboard_arrow_left_24),
                            contentDescription = ""
                        )
                    }
                    if (forwardIconShow) {
                        Icon(
                            modifier = Modifier
                                .clickable {
                                    viewModel.setProgressBarCount(progressBarCount + 1)
                                }
                                .align(Alignment.TopEnd),
                            painter = painterResource(
                                id =
                                    R.drawable.baseline_keyboard_arrow_right_24
                            ),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ProgressBar(progress: Int, size: Float) {
    LinearProgressIndicator(
        progress = { progress / size },
        modifier = Modifier.fillMaxWidth(),
        color = ProgressIndicatorDefaults.linearColor,
        trackColor = ProgressIndicatorDefaults.linearTrackColor,
        strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
    )
}