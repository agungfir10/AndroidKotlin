package com.agungfir.android.browser

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import com.agungfir.android.R


class CustomTabBrowserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_tab_browser)

        findViewById<Button>(R.id.btn_open_link).setOnClickListener {
//            val url: String = "https://paul.kinlan.me/"
//            val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
//            val customTabsIntent: CustomTabsIntent = builder.build()
//            customTabsIntent.launchUrl(this, Uri.parse(url))

            // with custom color toolbar
            val colorInt: Int = Color.parseColor("#FF0000") //red
            val defaultColors = CustomTabColorSchemeParams.Builder()
                .setToolbarColor(colorInt)
                .build()
            val intentBuilder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
            intentBuilder.setDefaultColorSchemeParams(defaultColors)
            val customTabIntent: CustomTabsIntent = intentBuilder.build()
            customTabIntent.launchUrl(this, Uri.parse("https://kentcdodds.com"))
        }
    }
}