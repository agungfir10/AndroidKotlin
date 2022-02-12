package com.agungfir.android.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R
import com.agungfir.android.countdown.CountDownActivity
import com.agungfir.android.imageview.ImageViewActivity
import com.agungfir.android.landcapevariant.LandscapeVariantActivity
import com.agungfir.android.runnable.RunnableActivity

class ListViewActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    val activities = listOf(
        ImageViewActivity::class.java,
        LandscapeVariantActivity::class.java,
        CountDownActivity::class.java,
        RunnableActivity::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        listView = findViewById(R.id.listView)

        var landmarkNames = arrayListOf(
            "Pisa",
            "Colloseum",
            "Eiffel",
            "London Bridge"
        )

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkNames)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this@ListViewActivity, landmarkNames[i], Toast.LENGTH_SHORT)
                .show()
        }

    }
}