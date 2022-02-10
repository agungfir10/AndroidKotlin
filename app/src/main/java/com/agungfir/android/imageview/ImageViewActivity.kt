package com.agungfir.android.imageview

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R

class ImageViewActivity : AppCompatActivity() {

    private lateinit var ivChanged: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        ivChanged = findViewById(R.id.ivChanged)
    }


    fun changeImage(view: View) {
        ivChanged.setImageResource(R.drawable.jaya_wijaya_mountain)
    }
}