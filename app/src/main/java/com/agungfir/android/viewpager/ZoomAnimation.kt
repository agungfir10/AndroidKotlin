package com.agungfir.android.viewpager

import android.content.Context
import android.util.Log
import android.view.View
import androidx.viewpager.widget.ViewPager

class ZoomAnimation : ViewPager.PageTransformer {

    companion object {
        const val MIN_SCALE = 0.70F
        const val MIN_ALPHA = 0.5F
    }

    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val pageHeight = page.height
        Log.i("POSITION", position.toString())

        if (position < -1) {
            page.alpha = 0F
        } else if (position <= 1) {
            val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
            val vertMargin = pageHeight * (1 - scaleFactor) / 2
            val horzMargin = pageWidth * (1 - scaleFactor) / 2
            if (position < 0) {
                page.translationX = horzMargin - vertMargin / 2
            } else {
                page.translationX = -horzMargin + vertMargin / 2
            }

            page.scaleX = scaleFactor
            page.scaleY = scaleFactor

            page.alpha = MIN_ALPHA + (scaleFactor - MIN_SCALE)

        } else {
            page.alpha = 0F
        }
    }
}