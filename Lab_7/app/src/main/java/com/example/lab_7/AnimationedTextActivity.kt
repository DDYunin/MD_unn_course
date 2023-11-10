package com.example.lab_7

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AnimationedTextActivity : AppCompatActivity() {

    private var isAnimating = false
    private var animationSet: AnimatorSet? = null
    private var delay = 2000;
    private lateinit var movingText: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animationed_text)

        movingText = findViewById(R.id.movingText)

        movingText.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Пользователь начал удерживать палец
                    if (!isAnimating) {
                        startAnimation(view)
                        isAnimating = true
                    }
                }
                MotionEvent.ACTION_UP -> {
                    // Пользователь отпустил палец
                    if (isAnimating) {
                        reverseAnimation(view)
                        isAnimating = false
                    }
                }
            }
            true
        }
    }

    private fun startAnimation(view: View) {
        val translationY = ObjectAnimator.ofFloat(movingText, "translationY", 0f, 1500f)
        translationY.duration = delay.toLong()

        val rotation = ObjectAnimator.ofFloat(movingText, "rotation", 0f, 180f)
        rotation.duration = delay.toLong()

        val colorAnim: ObjectAnimator =
            ObjectAnimator.ofInt(movingText, "textColor", Color.BLACK, Color.RED)
        colorAnim.setEvaluator(ArgbEvaluator())
        colorAnim.duration = delay.toLong()

        animationSet = AnimatorSet()
        animationSet?.playTogether(translationY, rotation, colorAnim)
        animationSet?.start()
    }

    private fun reverseAnimation(view: View) {
        animationSet?.reverse()
    }
}