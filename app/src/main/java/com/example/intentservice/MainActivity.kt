package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartService: Button = findViewById(R.id.btnStartService)
        val btnStopService: Button = findViewById(R.id.btnStopService)
        val tvServiceState: TextView = findViewById(R.id.tvServiceState)
        val tvCounter: TextView = findViewById(R.id.tvCounter)

        btnStartService.setOnClickListener {
            val intent = Intent(this, CounterIntentService::class.java)
            startService(intent)
            tvServiceState.text = "Service is Running"

            handler.postDelayed(object : Runnable {
                override fun run() {
                    tvCounter.text = CounterIntentService.counter.toString()
                    handler.postDelayed(this, 1000)
                }
            }, 1000)
        }



        btnStopService.setOnClickListener {
            CounterIntentService.stopService()
            tvServiceState.text = "Service is Stopped"
        }

    }
}