package com.example.lab_4.Task_2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.lab_4.R
import java.util.Stack

class Activity2 : AppCompatActivity() {


    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        supportFragmentManager.beginTransaction()
            .add(R.id.fcTop, TopFragment())
            .addToBackStack("FirstFragment")
            .commit()
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, Activity2::class.java)
    }
}