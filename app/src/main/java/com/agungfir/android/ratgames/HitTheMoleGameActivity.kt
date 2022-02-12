package com.agungfir.android.ratgames

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R
import kotlin.random.Random

class HitTheMoleGameActivity : AppCompatActivity() {

    var score: Int = 0
    var imageArray = arrayOf<ImageView>()

    var handler: Handler = Handler()
    var runnable: Runnable = Runnable { }
    private lateinit var tvScoreGame: TextView
    private lateinit var tvTimeGame: TextView
    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var imageView4: ImageView
    private lateinit var imageView5: ImageView
    private lateinit var imageView6: ImageView
    private lateinit var imageView7: ImageView
    private lateinit var imageView8: ImageView
    private lateinit var imageView9: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hit_the_mole_game)

        score = 0
        initView()
        initArrayImage()
        hideImages()

        object : CountDownTimer(10000, 1000) {
            override fun onTick(count: Long) {
                tvTimeGame.text = "Time : ${count / 1000}"
            }

            override fun onFinish() {
                tvTimeGame.text = "Time : 0"
                handler.removeCallbacks(runnable)
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
            }

        }.start()
    }

    private fun initArrayImage() {
        imageArray = arrayOf(
            imageView1,
            imageView2,
            imageView3,
            imageView4,
            imageView5,
            imageView6,
            imageView7,
            imageView8,
            imageView9
        )
    }

    fun hideImages() {
        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = Random
                val index = random.nextInt(0, imageArray.size)
                imageArray[index].visibility = View.VISIBLE

                handler.postDelayed(
                    runnable,
                    500
                )
            }
        }

        handler.post(runnable)
    }

    fun increaseScore(view: View) {
        score++

        tvScoreGame.text = "Score : $score"
    }

    private fun initView() {
        tvScoreGame = findViewById(R.id.tvScoreGame)
        tvTimeGame = findViewById(R.id.tvTimeGame)
        imageView1 = findViewById(R.id.imageView1)
        imageView2 = findViewById(R.id.imageView2)
        imageView3 = findViewById(R.id.imageView3)
        imageView4 = findViewById(R.id.imageView4)
        imageView5 = findViewById(R.id.imageView5)
        imageView6 = findViewById(R.id.imageView6)
        imageView7 = findViewById(R.id.imageView7)
        imageView8 = findViewById(R.id.imageView8)
        imageView9 = findViewById(R.id.imageView9)
    }
}