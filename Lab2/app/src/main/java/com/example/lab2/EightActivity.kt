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
import android.widget.EditText
import android.widget.TextView

class EightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_8)

        val cancelButton: Button = findViewById(R.id.cancelButton);
        val enterButton: Button = findViewById(R.id.enterButton);

        val sumTextView: TextView = findViewById(R.id.sumTextView);

        val firstInput: EditText = findViewById(R.id.firstInput);
        val secondInput: EditText = findViewById(R.id.secondInput);

        // При нажатии отмены - обнуляем поля ввода
        cancelButton.setOnClickListener {
            firstInput.setText("")
            secondInput.setText("")
            sumTextView.text = ""
        }

        // При нажатии подтверждения - складываем и ввыводим сумму в консоль
        enterButton.setOnClickListener {
            val firstNumber = firstInput.text.toString().toFloat()
            val secondNumber = secondInput.text.toString().toFloat()

            var sum = firstNumber + secondNumber;

            sumTextView.text = "Сумма: $sum"

            // Вывести число в консоль
            println("Сумма: $sum")
        }
    }
}