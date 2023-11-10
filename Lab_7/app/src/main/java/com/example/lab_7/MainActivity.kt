package com.example.lab_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentStep1_2 = Intent(this, TrafficLightActivity::class.java)
        val intentStep3 = Intent(this, AnimationedTextActivity::class.java)
        val intentStep4 = Intent(this, Task4Activity::class.java)
        val intentStep6 = Intent(this, TimerActivity::class.java)
        val intentStep7 = Intent(this, Activity7::class.java)
        val intentStep8 = Intent(this, SimpleTimer::class.java)
//
        val buttonTask1_2: Button = findViewById(R.id.button_task_1_2);
        val buttonTask3: Button = findViewById(R.id.button_task_3)
        val buttonTask4: Button = findViewById(R.id.button_task_4)
        val buttonTask6: Button = findViewById(R.id.button_task_6)
        val buttonTask7: Button = findViewById(R.id.button_task_7)
        val buttonTask8: Button = findViewById(R.id.button_task_8)


        buttonTask1_2.setOnClickListener {
            startActivity(intentStep1_2);
        }

        buttonTask3.setOnClickListener {
            startActivity(intentStep3);
        }

        buttonTask4.setOnClickListener {
            startActivity(intentStep4);
        }

        buttonTask6.setOnClickListener {
            startActivity(intentStep6);
        }

        buttonTask7.setOnClickListener {
            startActivity(intentStep7);
        }

        buttonTask8.setOnClickListener {
            startActivity(intentStep8);
        }
    }
}