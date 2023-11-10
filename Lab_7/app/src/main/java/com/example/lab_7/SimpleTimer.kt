package com.example.lab_7

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd

class SimpleTimer : AppCompatActivity() {
    private var running = false
    private var startTime: Long = 10
    private val handler = Handler()
    private lateinit var mainActivity: ConstraintLayout
    private lateinit var timeDisplay: TextView
    private val handlerColor = Handler()
    private var isClosed = false;

    private lateinit var runnableChangeColor: Runnable
    var delay = 300
    var currentState = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_timer)

        timeDisplay = findViewById(R.id.timeDisplay)
        val startButton = findViewById<Button>(R.id.startButton)
        val stopButton = findViewById<Button>(R.id.stopButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        mainActivity = findViewById(R.id.mainView);

        startButton.setOnClickListener {
            if (!running) {
                if (isClosed) {
                    handlerColor.removeCallbacks(runnableChangeColor)
                    isClosed = false;
                }
                mainActivity.setBackgroundResource(R.drawable.balck)
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
            timeDisplay.text = "00:00:10"
            running = false;
            handler.removeCallbacks(updateTime)
            startTime = 10
        }
    }

    fun celebrateUser() {
        Log.e("Test", "Я попал в celebrate")
        runnableChangeColor = object : Runnable {
            override fun run() {
                // Смена состояния светофора
                when (currentState) {
                    0 -> {
                        mainActivity.setBackgroundColor(Color.RED)
                    }
                    1 -> {
                        mainActivity.setBackgroundColor(Color.GREEN)
//                        mainActivity.setBackgroundResource(R.drawable.red_color_background)
                    }
                    3 -> {
                        mainActivity.setBackgroundColor(Color.BLUE)
//                        mainActivity.setBackgroundResource(R.drawable.red_color_background)
                    }
                    4 -> {
                        mainActivity.setBackgroundColor(Color.LTGRAY)
//                        mainActivity.setBackgroundResource(R.drawable.red_color_background)
                    }
                }
                currentState = (currentState + 1) % 4 // Переход к следующему состоянию
                handlerColor.postDelayed(this, delay.toLong())

            }
        }
        handlerColor.postDelayed(runnableChangeColor, 0)
        isClosed = true;
        timeDisplay.text = "00:00:10"
        handler.removeCallbacks(updateTime);
        running = false;
        startTime = 10;
    }

    private val updateTime: Runnable = object : Runnable {
        override fun run() {
            val currentTime = startTime--
            val hours = currentTime / 3600
            val minutes = (currentTime % 3600) / 60
            val seconds = (currentTime % 60)
            val timeText = String.format("%02d:%02d:%02d", hours, minutes, seconds)
            val timeDisplay = findViewById<TextView>(R.id.timeDisplay)
            timeDisplay.text = timeText
            if (currentTime.toInt() == 0) {
                Log.e("Test", "Я попал")
                celebrateUser();
                return;
            }
            handler.postDelayed(this, 1000) // Обновляем каждую секунду
        }
    }
}