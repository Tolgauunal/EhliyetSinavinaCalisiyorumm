package com.unallapps.ehliyetsinavinacalisiyorum.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.barteksc.pdfviewer.PDFView
import com.google.firebase.storage.FirebaseStorage
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.TestlerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@Composable
@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
fun PdfViewer(viewModel: PdfviewerViewModel = hiltViewModel()) {
    val pdfShow = remember {
        mutableStateOf(false)
    }
    val pdfUrlw: MutableStateFlow<ByteArray?> = MutableStateFlow(null)
    LaunchedEffect(key1 = true) {
        viewModel.firebaseListState.collect {
            when (it) {
                is TestlerState.resultPdf -> {
                    it.pdf?.let {
                        pdfShow.value = true
                        pdfUrlw.value = it
                    }
                }
                else -> {}
            }
        }
    }
    if (pdfShow.value) {
        val context = LocalContext.current
        AndroidView(factory = {
            PDFView(context, null).apply {
                fromBytes(pdfUrlw.value).enableSwipe(true).swipeHorizontal(false).enableDoubletap(true).load()
            }
        }, modifier = Modifier.fillMaxSize())
    }
}
