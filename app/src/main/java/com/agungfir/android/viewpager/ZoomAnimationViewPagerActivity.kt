package com.agungfir.android.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.agungfir.android.R
import com.agungfir.android.viewpager.fragments.FirstFragment
import com.agungfir.android.viewpager.fragments.SecondFragment
import com.agungfir.android.viewpager.fragments.ThirdFragment

class ZoomAnimationViewPagerActivity : AppCompatActivity() {

    private lateinit var viewPagerZoomAnimation: ViewPager
    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom_animation_view_pager)

        viewPagerZoomAnimation = findViewById(R.id.viewPagerZoomAnimation)

        val fragments = listOf(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )

        pagerAdapter = SlidePagerAdapter(supportFragmentManager, fragments)
        viewPagerZoomAnimation.setPageTransformer(true, ZoomAnimation())
        viewPagerZoomAnimation.adapter = pagerAdapter
    }
}