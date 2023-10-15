package com.example.lab_4

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.Stack

class Activity5 : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)

        button = findViewById(R.id.buttonTask5);
        textView = findViewById(R.id.textViewTask5);

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