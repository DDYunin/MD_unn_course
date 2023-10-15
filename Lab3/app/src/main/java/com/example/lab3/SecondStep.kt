package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondStep : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_2)

        val button: Button = findViewById(R.id.button);

        button.setOnClickListener {
            button.isPressed = true;
            button.isEnabled = false;
        }
    }
}