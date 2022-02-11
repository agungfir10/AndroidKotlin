package com.agungfir.android.bottomsheet

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ContentLoadingProgressBar
import com.agungfir.android.R
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MaterialBottomSheetActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ViewGroup>
    private lateinit var linearLayout: LinearLayout
    private lateinit var tbUpDown: ToggleButton
    private lateinit var listView: ListView
    private lateinit var tvTitleSong: TextView
    private lateinit var tvArtistSong: TextView
    private lateinit var progBar: ContentLoadingProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_bottom_sheet)

        supportActionBar?.title = "Music Player"

        initView()
        addSongs()

        tbUpDown.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }

        bottomSheetBehavior.setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                tbUpDown.isChecked = newState == BottomSheetBehavior.STATE_EXPANDED
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })
    }

    private fun initView() {
        this.linearLayout = findViewById(R.id.bottomSheetSongs)
        this.bottomSheetBehavior = BottomSheetBehavior.from(linearLayout)
        this.tbUpDown = findViewById(R.id.tbUpDown)
        this.listView = findViewById(R.id.listView)
        this.tvTitleSong = findViewById(R.id.tvTitleSong)
        this.tvArtistSong = findViewById(R.id.tvArtistSong)
        this.progBar = findViewById(R.id.progBar)
    }

    private fun addSongs() {

        val playlists = listOf(
            mapOf(
                "Text 1" to "Avenged Sevenfold",
                "Text 2" to "Dear God",
                "Duration" to "80"
            ),
            mapOf(
                "Text 1" to "Avenged Sevenfold",
                "Text 2" to "Size The Day",
                "Duration" to "40"
            ),
            mapOf(
                "Text 1" to "Avenged Sevenfold",
                "Text 2" to "Bat Country",
                "Duration" to "10"
            ),
            mapOf(
                "Text 1" to "Avenged Sevenfold",
                "Text 2" to "Demons",
                "Duration" to "90"
            ),
            mapOf(
                "Text 1" to "Avenged Sevenfold",
                "Text 2" to "Hail To The King",
                "Duration" to "50"
            ),
            mapOf(
                "Text 1" to "Avenged Sevenfold",
                "Text 2" to "Carry On",
                "Duration" to "60"
            )
        )


        val arrayAdapter =
            SimpleAdapter(
                this,
                playlists,
                android.R.layout.simple_list_item_2,
                arrayOf("Text 1", "Text 2"),
                intArrayOf(android.R.id.text1, android.R.id.text2)
            )
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            tvTitleSong.text = playlists.get(i).get("Text 1")
            tvArtistSong.text = playlists.get(i).get("Text 2")
            progBar.progress = playlists.get(i).get("Duration")?.toInt()!!
        }
    }
}
