package com.agungfir.android.runnable

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R

class RunnableActivity : AppCompatActivity() {

    var number: Int = 0
    var handler: Handler = Handler(mainLooper)
    var runnable: Runnable = Runnable {}
    private lateinit var tvTimer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runnable)

        tvTimer = findViewById(R.id.tvTimer)
    }

    fun start() {
        number = 0
        runnable = object : Runnable {
            override fun run() {
                tvTimer.text = "Time : $number"
                number++
                tvTimer.text = "Time : $number"
                handler.postDelayed(this, 100)
            }
        }

        handler.post(runnable)
    }

    fun reset() {
        handler.removeCallbacks(runnable)
        number = 0

        tvTimer.text = "Time : 0"
    }
}