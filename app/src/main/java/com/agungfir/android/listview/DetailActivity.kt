package com.agungfir.android.listview

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R

class DetailActivity : AppCompatActivity() {

    private lateinit var ivLandmark: ImageView
    private lateinit var tvLandmark: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
        val landmarkImage = intent.getParcelableExtra<Bitmap>("IMAGE")
        val landmarkName = intent.getStringExtra("LANDMARK")
        ivLandmark.setImageBitmap(landmarkImage)
        tvLandmark.text = landmarkName
    }

    private fun initView() {
        ivLandmark = findViewById(R.id.ivLandmark)
        tvLandmark = findViewById(R.id.tvLandmark)
    }
}