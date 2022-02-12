package com.agungfir.android.flashlight

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R

class FlashLightActivity : AppCompatActivity() {

    private lateinit var btnOnOffFlashlight: Button

    private var isLightOn = false
    private lateinit var cameraManager: CameraManager
    private lateinit var getCameraId: String

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_light)
        supportActionBar?.title = "Flash Light"

        initView()

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            getCameraId = cameraManager.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }

        btnOnOffFlashlight.setOnClickListener {
            if (isLightOn) {
                Toast.makeText(this, "Lampu Nyala", Toast.LENGTH_SHORT).show()
                try {
                    cameraManager.setTorchMode(getCameraId, true)
                    isLightOn = false
                    btnOnOffFlashlight.text = "Off"
                } catch (e: CameraAccessException) {
                    e.printStackTrace()
                }
            } else {
                Toast.makeText(this, "Lampu Mati", Toast.LENGTH_SHORT).show()
                try {
                    cameraManager.setTorchMode(getCameraId, false)
                    isLightOn = true
                    btnOnOffFlashlight.text = "On"
                } catch (e: CameraAccessException) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun initView() {
        btnOnOffFlashlight = findViewById(R.id.btnOnOffFlashlight)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun finish() {
        super.finish()
        try {
            cameraManager.setTorchMode(getCameraId, false)
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }
}