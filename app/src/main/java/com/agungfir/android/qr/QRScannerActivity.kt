package com.agungfir.android.qr

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.agungfir.android.R
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class QRScannerActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

    private lateinit var button: Button
    private lateinit var scannerView: ZXingScannerView
    private lateinit var scanner: ZXingScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrscanner)
        supportActionBar?.title = "QR Scanner"

        initView()

        checkPermissions()

        scannerView = ZXingScannerView(this)
        scanner.setResultHandler { rawResult ->

            val text: String = rawResult?.text.toString()
            val format: String = rawResult?.barcodeFormat.toString()

            Toast.makeText(
                this@QRScannerActivity,
                "Text : $text\nFormat : $format",
                Toast.LENGTH_SHORT
            ).show()
        }
        button.setOnClickListener {
//            generate()
            scanner.startCamera()
        }
    }

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "Aplikasi Tidak Di Izinkan Menggunakan Kamera", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun initView() {
        button = findViewById(R.id.button)
        scanner = findViewById(R.id.scanner)
    }

    private fun generate() {
        setContentView(scannerView)
        scannerView.setResultHandler(this)
        scannerView.startCamera()
    }

    override fun handleResult(rawResult: Result?) {
        val text: String
        val format: String

        text = rawResult?.text.toString()
        format = rawResult?.barcodeFormat.toString()

        Toast.makeText(this, "Text : $text\nFormat : $format", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        scannerView.stopCamera()
        scanner.stopCamera()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }
}