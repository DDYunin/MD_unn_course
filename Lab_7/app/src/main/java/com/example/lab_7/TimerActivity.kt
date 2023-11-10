package com.example.lab_7

import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity() {
    private var running = false
    private var startTime: Long = 0
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        val timeDisplay = findViewById<TextView>(R.id.timeDisplay)
        val startButton = findViewById<Button>(R.id.startButton)
        val stopButton = findViewById<Button>(R.id.stopButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        startButton.setOnClickListener {
            if (!running) {
                handler.post(updateTime)
                running = !running
            }
        }

        stopButton.setOnClickListener {
            if (running) {
                handler.removeCallbacks(updateTime)
                running = !running
            }
        }

        resetButton.setOnClickListener {
            timeDisplay.text = "00:00:00"
            running = false;
            handler.removeCallbacks(updateTime)
            startTime = 0
        }
    }

    private val updateTime: Runnable = object : Runnable {
        override fun run() {
            val currentTime = startTime++
            val hours = currentTime / 3600
            val minutes = (currentTime % 3600) / 60
            val seconds = (currentTime % 60)
            val timeText = String.format("%02d:%02d:%02d", hours, minutes, seconds)
            val timeDisplay = findViewById<TextView>(R.id.timeDisplay)
            timeDisplay.text = timeText
            handler.postDelayed(this, 1000) // Обновляем каждую секунду
        }
    }
}