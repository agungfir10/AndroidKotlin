package com.agungfir.android.browser

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R

class WebBrowserActivity : AppCompatActivity() {

    private lateinit var btnGoto: Button
    private lateinit var edtUrl: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var webView: WebView

    // siapkan uri
    private var url = "https://google.co.id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_browser)

        initView()


        // inisialisasi kebutuhan browser
        setupBrowser(url)

        // onclick
        onClick()
    }

    private fun onClick() {
        btnGoto.setOnClickListener {
            url = edtUrl.text.toString()

            // aktifkan javascript
            setupBrowser(url)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupBrowser(gotoUrl: String) {
        webView.settings.apply {
            javaScriptEnabled = true
            displayZoomControls = true
            loadWithOverviewMode = true
            useWideViewPort = true
            javaScriptCanOpenWindowsAutomatically = true
            allowFileAccess = true
            allowUniversalAccessFromFileURLs = true
            allowFileAccessFromFileURLs = true
        }
        webView.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY

        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                progressBar.visibility = View.VISIBLE
                progressBar.progress = newProgress
                if (newProgress == 100) {
                    progressBar.visibility = View.GONE
                }
            }
        }

        webView.loadUrl(if (gotoUrl.isNullOrEmpty()) url else gotoUrl)
        webView.webViewClient = MyWebLaunch()
    }

    private fun initView() {
        btnGoto = findViewById(R.id.btnGoto)
        edtUrl = findViewById(R.id.edtUrl)
        progressBar = findViewById(R.id.progressBar)
        webView = findViewById(R.id.webView)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (event?.action == KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (webView.canGoBack()) {
                        webView.goBack()
                    } else {
                        finish()
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)

    }

}