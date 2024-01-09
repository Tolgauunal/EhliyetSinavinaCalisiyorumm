package com.unallapps.ehliyetsinavinacalisiyorum.ui.konular

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.BilgiKartlariEntity

@SuppressLint("UnrememberedMutableState")
@Composable
fun KonuAnlatim(konuAdi: String,
    paddingModifier: Modifier,
    konuAnlatimViewModel: KonuAnlatimViewModel = hiltViewModel()) {

}
