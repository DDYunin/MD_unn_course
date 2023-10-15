package com.example.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val label = findViewById<TextView>(R.id.numberClick)
        val button: Button = findViewById(R.id.clickButton)
        var numberClicked = 0;

        button.setOnClickListener {
            numberClicked++;
            label.setText(
                numberClicked.toString()
            );
        }
    }

}