package com.example.lab_7

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd

class TrafficLightActivity : AppCompatActivity() {
    private val handler = Handler()
    private lateinit var runnable: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic_light)

        val redLight = findViewById<ImageView>(R.id.redLight)
        val yellowLight = findViewById<ImageView>(R.id.yellowLight)
        val greenLight = findViewById<ImageView>(R.id.greenLight)
        val walker = findViewById<ImageView>(R.id.walker)
        var posXStart = 0f
        var posXEnd = 750f

        var delay = 3000 // Интервал в миллисекундах (например, 3 секунды)

        var currentState = 0 // 0 - Красный, 1 - Желтый, 2 - Зеленый

        runnable = object : Runnable {
            override fun run() {
                // Смена состояния светофора
                when (currentState) {
                    0 -> {
                        redLight.setImageResource(R.drawable.red_light)
                        greenLight.setImageResource(R.drawable.grey_light)
                        delay = 3000;
                    }
                    1 -> {
                        yellowLight.setImageResource(R.drawable.yellow_light)
                        delay = 2000;
                    }
                    2 -> {
                        redLight.setImageResource(R.drawable.grey_light)
                        yellowLight.setImageResource(R.drawable.grey_light)
                        greenLight.setImageResource(R.drawable.green_light)
                        delay = 5000;
                        // StickMan animation
                        val anim = ObjectAnimator.ofFloat(walker, "translationX", posXStart, posXEnd)
                        anim.duration = delay.toLong()
                        anim.doOnEnd { walker.scaleX = walker.scaleX * -1 }
                        anim.start()
                        posXStart = posXEnd.also { posXEnd = posXStart }
                        // End of StickMan animation
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