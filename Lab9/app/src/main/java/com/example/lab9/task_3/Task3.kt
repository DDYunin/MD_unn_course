package com.example.lab9.task_3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.lab9.R
import com.plattysoft.leonids.ParticleSystem


class Task3 : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_particles)

        // Assuming you have a FrameLayout with id 'container' in your layout
        val container: FrameLayout = findViewById(R.id.container)
        container.setOnTouchListener { _, event ->
            handleTouch(event)
        }
    }

    private fun handleTouch(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                createParticle(event.x, event.y)
            }
        }
        return true
    }

    private fun createParticle(x: Float, y: Float) {
        ParticleSystem(this, 100, R.drawable.star_particle, 1000)
            .setSpeedRange(0.2f, 0.5f)
            .emit(x.toInt(), y.toInt(), 50, 1000)

        ParticleSystem(this, 100, R.drawable.circle_particle, 1000)
            .setSpeedRange(0.2f, 0.5f)
            .emit(x.toInt(), y.toInt(), 50, 1000)
    }
}