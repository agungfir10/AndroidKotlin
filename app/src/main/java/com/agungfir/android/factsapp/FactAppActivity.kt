package com.agungfir.android.factsapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R
import kotlin.random.Random

class FactAppActivity : AppCompatActivity() {

    private val facts = arrayOf(
        "Jika kita mandi menggunakan air, maka kemungkinan besar kita badan kita akan basah",
        "Ir. Soekarno adalah presiden pertama di negara Indonesia",
        "Jika kita minum sehari, maka akan menyebabkan kita kembung",
        "Jika kita mengerti fakta lain, ya share lah disini!"
    )

    private val colorsFact = arrayOf(
        "#BB86FC",
        "#6200EE",
        "#018786",
        "#13D3FB",
        "#FB1467",
        "#F5815C",
        "#148CFB",
        "#8C8C8C",
        "#4D000000"
    )


    private lateinit var btnNextFacts: Button
    private lateinit var tvFact: TextView
    private lateinit var layoutFact: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fact_app)

        initView()
        onclick()
    }

    private fun onclick() {
        btnNextFacts.setOnClickListener {
            val randomFact = Random.nextInt(0, facts.size)
            tvFact.text = facts[randomFact]

            val randomColor = Random.nextInt(0, colorsFact.size)
            layoutFact.setBackgroundColor(Color.parseColor(colorsFact[randomColor]))
        }
    }

    private fun initView() {
        btnNextFacts = findViewById(R.id.btnNextFact)
        tvFact = findViewById(R.id.tvFact)
        layoutFact = findViewById(R.id.layoutFact)
    }
}