package com.agungfir.android.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var URL: String

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        supportActionBar?.title = "Web View"

        URL = "https://1cak.com"
        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.goBackOrForward(2)
        webView.loadUrl(URL)
        webView.webViewClient = WebViewClient()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}