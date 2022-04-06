package com.agungfir.android.stepper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.agungfir.android.R

class StepperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stepper)

        findViewById<RecyclerView>(R.id.rv_step).adapter = StepAdapter(this)
    }
}