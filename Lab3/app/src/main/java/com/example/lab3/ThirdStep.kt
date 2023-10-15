package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView

class ThirdStep : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_3)

        val buttonStep3: Button = findViewById(R.id.buttonStep3);
        val textView3: TextView = findViewById(R.id.textViewStep3);

        // Понадобится обработчик события нажатия/отпускания кнопки
        buttonStep3.setOnTouchListener { _, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                textView3.text = "Нажата"
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                textView3.text = "Отпущена"
            }
            // Должно ли дальше расспространяться событие
            true
        }
    }
}