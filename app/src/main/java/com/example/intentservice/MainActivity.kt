package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartService: Button = findViewById(R.id.btnStartService)
        val btnStopService: Button = findViewById(R.id.btnStopService)
        val btnSendData: Button = findViewById(R.id.btnSendData)
        val tvServiceState: TextView = findViewById(R.id.tvServiceState)
        val editText: EditText = findViewById(R.id.editTextText)
        val tvCounter: TextView = findViewById(R.id.tvCounter)

        btnStartService.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
            tvServiceState.text = "Service is Running"

//            handler.postDelayed(object : Runnable {
//                override fun run() {
//                    tvCounter.text = CounterIntentService.counter.toString()
//                    handler.postDelayed(this, 1000)
//                }
//            }, 1000)
        }

        btnStopService.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
            tvServiceState.text = "Service is Stopping"
        }

        btnSendData.setOnClickListener {
            val dataString = editText.text.toString()
            val intent = Intent(this, MyService::class.java)
                .putExtra("EXTRA_DATA", dataString)
            startService(intent)
        }
    }
}