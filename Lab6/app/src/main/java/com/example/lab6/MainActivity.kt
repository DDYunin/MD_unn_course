package com.example.lab6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentStep1_3 = Intent(this, Task_1::class.java)
        val intentStep2 = Intent(this, Task_2::class.java)
        val intentStep4 = Intent(this, Task_4::class.java)
        val intentStep5 = Intent(this, Task_3::class.java)
        val intentStep6 = Intent(this, Task_6::class.java)
        val intentStep7 = Intent(this, Task_7::class.java)
        val intentStep8 = Intent(this, Task_8::class.java)

        val buttonTask1_3: Button = findViewById(R.id.buttonTask1_3);
        val buttonTask2: Button = findViewById(R.id.buttonTask2)
        val buttonTask4: Button = findViewById(R.id.buttonTask4)
        val buttonTask5: Button = findViewById(R.id.buttonTask5)
        val buttonTask6: Button = findViewById(R.id.buttonTask6)
        val buttonTask7: Button = findViewById(R.id.buttonTask7)
        val buttonTask8: Button = findViewById(R.id.buttonTask8)

        buttonTask1_3.setOnClickListener {
            startActivity(intentStep1_3);
        }

        buttonTask2.setOnClickListener {
            startActivity(intentStep2);
        }

        buttonTask4.setOnClickListener {
            startActivity(intentStep4);
        }

        buttonTask5.setOnClickListener {
            startActivity(intentStep5);
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