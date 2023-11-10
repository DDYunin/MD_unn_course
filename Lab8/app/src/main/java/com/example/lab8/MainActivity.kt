package com.example.lab8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentCounter = Intent(this, CounterActivity::class.java)
        val intentWords = Intent(this, WordsActivity::class.java)

        val buttonCounter: Button = findViewById(R.id.buttonCounterActivity);
        val buttonWords: Button = findViewById(R.id.buttonWords);

        buttonCounter.setOnClickListener {
            startActivity(intentCounter);
        }

        buttonWords.setOnClickListener {
            startActivity(intentWords);
        }
    }
}