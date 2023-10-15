package com.example.lab3

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Calendar

class SixStep : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_6)

        button = findViewById(R.id.buttonTime);
        textView = findViewById(R.id.textTime);

        button.setOnClickListener {
            this.showTimeDialog();
        }
    }

    private fun showTimeDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->

                textView.text = "Hours: " + hourOfDay + " Minutes: " + minute;
            },
            12,
            0,
            true
        )
        timePickerDialog.show()
    }
}