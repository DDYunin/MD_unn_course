package com.example.lab9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.lab9.task_1.Task1
import com.example.lab9.task_2.Task2
import com.example.lab9.task_3.Task3
import com.example.lab9.task_4.Task4

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Кнопки
        val buttonTask1: Button = findViewById(R.id.buttonTask1);
        val buttonTask2: Button = findViewById(R.id.buttonTask2);
        val buttonTask3: Button = findViewById(R.id.buttonTask3);
        val buttonTask4: Button = findViewById(R.id.buttonTask4);
        val buttonTask5: Button = findViewById(R.id.buttonTask5);
        val buttonTask6: Button = findViewById(R.id.buttonTask6);

        // Обработка событий
        buttonTask1.setOnClickListener {
            startActivity(Intent(this, Task1::class.java))
        }

        buttonTask2.setOnClickListener {
            startActivity(Intent(this, Task2::class.java))
        }

        buttonTask3.setOnClickListener {
            startActivity(Intent(this, Task3::class.java))
        }

        buttonTask4.setOnClickListener {
            startActivity(Intent(this, Task4::class.java))
        }

        buttonTask5.setOnClickListener {
            startActivity(Intent(this, MusicPlayerActivity::class.java))
        }

        buttonTask6.setOnClickListener {
            startActivity(Intent(this, VideoPlayerActivity::class.java))
        }
    }
}