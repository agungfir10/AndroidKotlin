package com.agungfir.android.gridlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R

class GridLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_layout)
        supportActionBar?.title = "Grid Layout"
    }
}