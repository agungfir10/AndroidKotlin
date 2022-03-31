package com.agungfir.android.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.agungfir.android.R

class MyActivity : ComponentActivity(R.layout.activity_my) {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.MyTheme)
        super.onCreate(savedInstanceState)
    }

}