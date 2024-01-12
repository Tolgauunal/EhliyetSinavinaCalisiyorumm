package com.unallapps.ehliyetsinavinacalisiyorum.ui.konular

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun KonuAnlatim(konuAdi: String,
    paddingModifier: Modifier,
    konuAnlatimViewModel: KonuAnlatimViewModel = hiltViewModel()) {
    val filePath ="file:///android_asset/$konuAdi.html"
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
