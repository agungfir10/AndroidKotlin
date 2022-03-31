package com.agungfir.android.layoutinflater

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R

class LayoutInflaterActivity : AppCompatActivity(R.layout.activity_layout_inflater) {

    private lateinit var containerFirst: LinearLayout
    private lateinit var containerSecond: LinearLayout
    private lateinit var subActivityFirst: View
    private lateinit var subActivitySecond: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        setupLayoutInflater()
        addView()
        onClick()
    }

    private fun onClick() {
        subActivityFirst.findViewById<Button>(R.id.btnSubActivityFirst).setOnClickListener {
            val ivFirstSubActivitySecond =
                subActivitySecond.findViewById<ImageView>(R.id.ivFirstSubActivitySecond)
            val ivSecondSubActivitySecond =
                subActivitySecond.findViewById<ImageView>(R.id.ivSecondSubActivitySecond)

            if (ivFirstSubActivitySecond.tag == null) {
                ivFirstSubActivitySecond.setImageResource(R.drawable.ic_avatar_1)
                ivFirstSubActivitySecond.tag = "ivFirstSubActivitySecond"
            } else {
                ivFirstSubActivitySecond.setImageResource(R.drawable.ic_avatar_5)
                ivFirstSubActivitySecond.tag = null
            }

            if (ivSecondSubActivitySecond.tag == null) {
                ivSecondSubActivitySecond.tag = "ivSecondSubActivitySecond"
                ivSecondSubActivitySecond.setImageResource(R.drawable.ic_avatar_10)
            } else {
                ivSecondSubActivitySecond.setImageResource(R.drawable.ic_avatar_6)
                ivSecondSubActivitySecond.tag = null
            }

        }
    }

    private fun addView() {
        containerFirst.addView(subActivityFirst)
        containerSecond.addView(subActivitySecond)
    }

    private fun setupLayoutInflater() {
        subActivityFirst =
            layoutInflater.inflate(R.layout.activity_sub_first, containerFirst, false)
        subActivitySecond =
            layoutInflater.inflate(R.layout.activity_sub_second, containerFirst, false)

    }

    private fun initView() {
        containerFirst = findViewById(R.id.containerFirst)
        containerSecond = findViewById(R.id.containerSecond)
    }
}