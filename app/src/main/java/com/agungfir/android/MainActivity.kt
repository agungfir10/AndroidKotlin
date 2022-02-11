package com.agungfir.android

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.bottomsheet.MaterialBottomSheetActivity
import com.agungfir.android.countdown.CountDownActivity
import com.agungfir.android.gridlayout.GridLayoutActivity
import com.agungfir.android.imageview.ImageViewActivity
import com.agungfir.android.landcapevariant.LandscapeVariantActivity
import com.agungfir.android.listview.ListViewActivity
import com.agungfir.android.radiobutton.RadioButtonActivity
import com.agungfir.android.runnable.RunnableActivity
import com.agungfir.android.viewmodel.ViewModelAppActivity
import com.agungfir.android.viewpager.ZoomAnimationViewPagerActivity

class MainActivity : AppCompatActivity() {

    val activities = listOf(
        MaterialBottomSheetActivity::class.java,
        CountDownActivity::class.java,
        GridLayoutActivity::class.java,
        ImageViewActivity::class.java,
        LandscapeVariantActivity::class.java,
        ListViewActivity::class.java,
        RadioButtonActivity::class.java,
        RunnableActivity::class.java,
        ViewModelAppActivity::class.java,
        ZoomAnimationViewPagerActivity::class.java
    )

    val appsName = arrayListOf(
        "Bottom Sheet Music",
        "Count Down Apps",
        "Grid Layout",
        "Image View",
        "Landscape Variant",
        "List View",
        "Radio Button",
        "Runnable",
        "View Model",
        "View Pager"
    )

    private lateinit var listViewApps: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, appsName)
        this.listViewApps.adapter = arrayAdapter

        onclick()
    }

    private fun onclick() {
        listViewApps.setOnItemClickListener { _, _, i, _ ->
            startActivity(Intent(this@MainActivity, activities[i]))
        }
    }

    private fun initView() {
        this.listViewApps = findViewById(R.id.listViewApps)
    }
}