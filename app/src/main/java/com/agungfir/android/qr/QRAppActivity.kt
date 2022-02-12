package com.agungfir.android.qr

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.android.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder

class QRAppActivity : AppCompatActivity() {
    private lateinit var btnConvert: Button
    private lateinit var edtQuickResponse: EditText
    private lateinit var ivQuickResponse: ImageView
    private val multiFormatWriter = MultiFormatWriter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrapp)

        initView()
        btnConvert.setOnClickListener {
            try {
                val bitMatrix: BitMatrix =
                    multiFormatWriter.encode(
                        edtQuickResponse.text.toString(),
                        BarcodeFormat.QR_CODE,
                        200,
                        200
                    )
                val encode: BarcodeEncoder = BarcodeEncoder()
                val bitmap: Bitmap = encode.createBitmap(bitMatrix)
                ivQuickResponse.setImageBitmap(bitmap)
            } catch (e: WriterException) {
                e.printStackTrace()
            }
        }
    }

    private fun initView() {
        btnConvert = findViewById(R.id.btnConvert)
        edtQuickResponse = findViewById(R.id.edtQuickResponse)
        ivQuickResponse = findViewById(R.id.ivQuickResponse)
    }
}