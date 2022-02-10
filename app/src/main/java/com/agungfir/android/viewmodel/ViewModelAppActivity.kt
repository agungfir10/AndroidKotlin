package com.agungfir.android.viewmodel

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.agungfir.android.R

class ViewModelAppActivity : AppCompatActivity() {

    private lateinit var personViewModel: NameViewModel
    private lateinit var tvName: TextView
    private lateinit var btnChangeName: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel_app)
        tvName = findViewById(R.id.tvName)
        btnChangeName = findViewById(R.id.btnChangeName)

        personViewModel = ViewModelProvider(this).get(NameViewModel::class.java)


        personViewModel.name.observe(this, {
            tvName.text = it
        })

        btnChangeName.setOnClickListener {
            personViewModel.changeName("Firmansyah")
        }

    }
}