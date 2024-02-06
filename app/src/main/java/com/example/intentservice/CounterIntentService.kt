package com.example.intentservice

import android.app.IntentService
import android.content.Intent
import android.util.Log

class CounterIntentService: IntentService("CounterIntentService") {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: CounterIntentService
        var isRunning = false
        var counter = 0
        fun stopService() {
            isRunning = false
            instance.stopSelf()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(p0: Intent?) {

        try {
            isRunning = true
            while (isRunning) {
                counter++
                Thread.sleep(1000)
            }
        }catch (e : InterruptedException) {
            Thread.currentThread().interrupt()
        }

    }
}