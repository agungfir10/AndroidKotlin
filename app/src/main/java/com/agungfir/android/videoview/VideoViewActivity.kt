package com.agungfir.android.videoview

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R

class VideoViewActivity : AppCompatActivity() {

    private lateinit var btnPlay: Button
    private lateinit var videoView: VideoView
    private lateinit var mediaController: MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        initView()
        initMediaController()
        onClick()
    }

    private fun onClick() {
        btnPlay.setOnClickListener {
            playVideo()
        }
    }

    private fun initMediaController() {
        mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
    }

    private fun playVideo() {
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video)
        videoView.setVideoURI(uri)
        videoView.setMediaController(mediaController)
        videoView.start()
    }

    private fun initView() {
        videoView = findViewById(R.id.videoView)
        btnPlay = findViewById(R.id.btnPlay)
    }
}