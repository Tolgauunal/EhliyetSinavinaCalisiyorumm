package com.unallapps.ehliyetsinavinacalisiyorum.ui.subject

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("UnrememberedMutableState", "SetJavaScriptEnabled")
@Composable
fun SubjectFilter(
    subjectName: String,
    modifier: Modifier
) {
    val filePath = "file:///android_asset/$subjectName.html"
    Column(modifier = modifier) {
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()

                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true
                    settings.setSupportZoom(true)
                }
            },
            update = { webView ->
                webView.loadUrl(filePath)
            }
        )
    }

}
