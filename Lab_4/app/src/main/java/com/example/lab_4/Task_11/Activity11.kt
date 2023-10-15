package com.example.lab_4.Task_11

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_4.R

class Activity11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_11)

        val startServiceIntent = Intent(this, MyForegroundService::class.java)
        startService(startServiceIntent)

    }
}