package com.example.lab2

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.Button

class SevenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_7)

        val greenSquare: View = findViewById(R.id.greenSquare);

        // Вычислите высоту экрана
        val screenHeight = resources.displayMetrics.heightPixels.toFloat()

        // Создайте анимацию перемещения сверху вниз
        val translateYAnimation = ObjectAnimator.ofFloat(greenSquare, "translationY", 0f, screenHeight)
        translateYAnimation.duration = 5000 // Длительность анимации перемещения в миллисекундах

        // Создайте анимацию изменения размера
        val scaleAnimation = ObjectAnimator.ofFloat(greenSquare, "scaleX", 1f, 7f)
        scaleAnimation.duration = 5000 // Длительность анимации изменения размера в миллисекундах

        // Создайте анимацию масштабирования по оси Y
        val scaleYAnimation = ObjectAnimator.ofFloat(greenSquare, "scaleY", 1f, 7f)
        scaleYAnimation.duration = 5000 // Длительность анимации масштабирования в миллисекундах


        // Создайте AnimatorSet и добавьте обе анимации
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(translateYAnimation, scaleAnimation, scaleYAnimation) // Запускать обе анимации одновременно

        // Установите слушатель анимации
        animatorSet.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}

            override fun onAnimationEnd(animation: Animator) {
                // Перезапустите анимацию при завершении
                animatorSet.start()
            }

            override fun onAnimationCancel(animation: Animator) {}

            override fun onAnimationRepeat(animation: Animator) {}
        })

        // Запустите анимацию
        animatorSet.start()


    }
}