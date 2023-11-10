package com.example.lab_7

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd

class Task4Activity : AppCompatActivity() {
    private val handler = Handler()
    private lateinit var runnable: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_4)

        val trafficLight = findViewById<TrafficLightView>(R.id.trafficLight)

        var delay = 3000 // Интервал в миллисекундах (например, 3 секунды)

        var currentState = 0 // 0 - Красный, 1 - Желтый, 2 - Зеленый

        runnable = object : Runnable {
            override fun run() {
                // Смена состояния светофора
                when (currentState) {
                    0 -> {
                        trafficLight.setSignal(Signal.RED)
                        trafficLight.clearSignal(Signal.GREEN)
                        delay = 3000;
                    }
                    1 -> {
                        trafficLight.setSignal(Signal.YELLOW)
                        delay = 2000;
                    }
                    2 -> {
                        trafficLight.clearSignal(Signal.RED)
                        trafficLight.clearSignal(Signal.YELLOW)
                        trafficLight.setSignal(Signal.GREEN)
                        delay = 5000;

                    }
                }
                currentState = (currentState + 1) % 3 // Переход к следующему состоянию
                handler.postDelayed(this, delay.toLong())
            }
        }

        handler.postDelayed(runnable, 0)

    }

    override fun onDestroy() {
        super.onDestroy()

        // Остановка автоматической смены состояний при уничтожении активности
        handler.removeCallbacks(runnable)
    }
}