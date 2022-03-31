package com.agungfir.android.browser

import android.webkit.WebView
import android.webkit.WebViewClient

class MyWebLaunch : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        view?.loadUrl(url!!)
        return super.shouldOverrideUrlLoading(view, url)
    }

}
