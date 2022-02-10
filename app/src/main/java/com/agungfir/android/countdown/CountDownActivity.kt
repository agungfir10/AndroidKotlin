package com.agungfir.android.countdown

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R

class CountDownActivity : AppCompatActivity() {
    private lateinit var tvCount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)

        tvCount = findViewById(R.id.tvCount)

        object : CountDownTimer(10000, 1000) {
            override fun onTick(count: Long) {
                Toast.makeText(this@CountDownActivity, "Time's OFF", Toast.LENGTH_SHORT).show()
                tvCount.text = "Left: ${count / 1000}"
            }

            override fun onFinish() {
                tvCount.text = "Left: 0"
            }

        }.start()
    }
}