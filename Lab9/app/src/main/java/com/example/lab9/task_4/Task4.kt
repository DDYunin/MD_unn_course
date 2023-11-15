package com.example.lab9.task_4

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.lab9.R
import com.plattysoft.leonids.ParticleSystem


class Task4 : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_particles)

        // Assuming you have a FrameLayout with id 'container' in your layout
        val container: View = findViewById(R.id.container)
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
            // Add gravity by setting acceleration (adjust the values as needed)
            .setAcceleration(0.01f, 100)
            .emit(x.toInt(), y.toInt(), 50, 1000)

        ParticleSystem(this, 100, R.drawable.circle_particle, 1000)
            .setSpeedRange(0.2f, 0.5f)
            // Add gravity by setting acceleration (adjust the values as needed)
            .setAcceleration(-0.01f, 100)
            .emit(x.toInt(), y.toInt(), 50, 1000)
    }
}