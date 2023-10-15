package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FourStep : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_4)

        val buttonStep4: Button = findViewById(R.id.buttonStep4);
        val buttonBaseText = "Счётчик ";

        var numberClicks = 0;

        buttonStep4.text = buttonBaseText + numberClicks.toString();

        buttonStep4.setOnClickListener {
            numberClicks++;
            buttonStep4.text = buttonBaseText + numberClicks.toString();
        }
    }
}